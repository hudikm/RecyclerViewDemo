# Úvod
> **Cvičenie** : Úlohou cvičenia je vytvoriť aplikáciu kuchárska kniha, ktorá bude pozostávať z dvoch obrazoviek. Práva hlavná obrazovka bude obsahovať zoznam receptov a druhá bu zobrazovať detail o recepte. Na aplikáciu su kladené tieto požiadavky:
>
> 1. Aplikacia použije dynamický layoutu a to konkrétne Recyclerview.  Tento prvok bude zobrazovať zoznam receptov.
> 2. Obrazovky uživatelského rozhrania budú tvorené z dvoch fragmentov: ListFagment, DetailFragment. 

## Čo je to Recycleview?
- RecyclerView je pokročilejšia a flexibilnejšia verzia ListView dynamického layoutu  
- Efektívny na zobrazovanie veľkého množstvo dát, ktoré sú uložené v „rolovacom“ zozname. Pri zobrazovaní automaticky využíva  ViewHolder návrhový vzor.
- RecyclerView zjednodušuje zobrazovanie a správu veľkých dát za pomoci:
  - **Layout manažéra** určeného na zobrazovanie položiek
  - Štandardných animácií pre základné operácie s prvkami(pridanie odobranie prvkov

![](img/RecyclerView.png)
*Zloženie RecyclerView*

- RecyclerView poskytuje týchto správcov pre manažovanie zobrazenia layoutu:
  - LinearLayoutManager 
  - GridLayoutManager
  - StaggeredGridLayoutManager
- Animácie
!!! info
	[Viac info o RecyclerView ext. zdroj](https://www.grokkingandroid.com/first-glance-androids-recyclerview)<br/>
	[Viac info o RecyclerView na developer.android.com](https://developer.android.com/guide/topics/ui/layout/recyclerview)




