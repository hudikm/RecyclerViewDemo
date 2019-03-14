package sk.fri.uniza.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyRecipeRecyclerViewAdapter.OnRecipeListInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        // Testovanie či už fragmenty neexistujú
        if ((getSupportFragmentManager().findFragmentByTag("detailFragment") == null)
                && (getSupportFragmentManager().findFragmentByTag("listFragment") == null)) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ListFragment(), "listFragment")
                    .commit();
        }


    }

    // Vytvorenie detail fragmentu
    @Override
    public void onRecipeClick(int position) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailFragment.createDetailFragment(position), "detailFragment")
                .addToBackStack(null)
                .commit();
    }

}
