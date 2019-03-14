<script>mermaid.initialize({startOnLoad:true});</script>
# Interakcia RecyclerView s Aktivitou

Pod pojmom interakcia sa rozumie udalosť kedy používatel klikne na položku v zozname (ďalej recept) a následne sa vyvolaná udalosť obslúži v hlavnej aktivite. 
<div class="mermaid">
  sequenceDiagram
     participant UI as UI
     participant adapter as RecylerViewAdapter
     participant act as Aktivita
     Note over UI: Používateľ klikne na <br> položku v zozname
     UI ->>adapter: onClick()
     activate adapter
     adapter->>act: onItemClick()
     deactivate adapter
</div>

## 1. Definovanie rozhrania (interface)

```plantuml format="svg" classes="class myDiagram" alt="class diagram" title="Diagram rozhrania" width="300px" 
    skinparam Class {
    	ArrowColor #000000
    	ArrowThickness 1
    	AttributeFontColor	#004D40
    	BackgroundColor	#ECECFF
    	BorderColor	#ccf
    	FontColor #000000
    	HeaderBackgroundColor  #eaeafa
    	StereotypeFontColor	#009688
    }
    skinparam roundcorner 10
    skinparam shadowing false
    class MainActivity {
        + onRecipeClick()
    }

    class MyRecipeRecyclerViewAdapter {
        - OnRecipeListInteraction : mListener
    }

    interface OnRecipeListInteraction {
        {abstract} + onRecipeClick()
    }

  MainActivity -up-|> OnRecipeListInteraction
  MyRecipeRecyclerViewAdapter o-- OnRecipeListInteraction : mListener
  MyRecipeRecyclerViewAdapter +-down- OnRecipeListInteraction
```

V triede `MyRecipeRecyclerViewAdapter` definujte nové rozhranie  `OnRecipeListInteraction`, obsahujúce jednu metódu `onRecipeClick(int position)` .

```java
	/**
     * This interface must be implemented by activities that contain this
     * recycleview to allow an interaction.
     */
    public interface OnRecipeListInteraction {
        void onRecipeClick(int position);

    }
```

V triede `MyRecipeRecyclerViewAdapter` definujte nový atribút, ktorý bude držať inštanciu tohoto rozhrania a do konštruktora doplte jeho inicializáciu 

```java
private final OnRecipeListInteraction mListener;

public MyRecipeRecyclerViewAdapter(List<Recipe> items, OnRecipeListInteraction listener) {
        recipes = items;
        mListener = listener;
    }
```

## 2. Spracovanie udalosti po kliknutí na recept

Na to aby sme mohli spracovať udalosť musíme v triede  `MyRecipeRecyclerViewAdapter` doplniť do metódy `onBindViewHolder` nasledovný kód:

```java
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.contentText.setText(recipes.get(i).title);
        viewHolder.smallImageView.setImageBitmap(recipes.get(i).getBitmapFromAsset());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send click event to MainActivity
                mListener.onRecipeClick(i);
            }
        });
    }

```

### 2.1 Implentácia rozhrania v hlavnej aktivite

Ak chceme udalosť, že používateľ klikol na recept spracovať v hlavnej aktivite, musíme implementovať rozhranie v triede prislúchajúcej hlavnej aktivite `MainActivity`. Udalosť obslúžime zobrazíním názvu receptu pomocou grafického prvku `Toas`.

```java
public class MainActivity extends AppCompatActivity implements MyRecipeRecyclerViewAdapter.OnRecipeListInteraction {


    @Override
    public void onRecipeClick(int position) {
        Toast.makeText(this, RecipesDataSet.getRecipes(this).get(position).title, Toast.LENGTH_LONG).show();
    }
...
```

### 2.2 Inicializácia MyRecipeRecyclerViewAdapter

Posledný krok je upraviť inštancovanie adaptéra `MyRecipeRecyclerViewAdapter`tak aby zodpovedal novému konštruktoru t.j. treba doplniť referenciu na implementované rozhranie  `OnRecipeListInteraction`.

```diff
- MyRecipeRecyclerViewAdapter mAdapter = new MyRecipeRecyclerViewAdapter(RecipesDataSet.getRecipes(this));
+ MyRecipeRecyclerViewAdapter mAdapter = new MyRecipeRecyclerViewAdapter(RecipesDataSet.getRecipes(this), this);
```



**Finish** : Po tomto kroku by aplikácia mala fungovať.

