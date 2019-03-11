package sk.fri.uniza.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import sk.fri.uniza.recyclerviewdemo.model.Recipe;

public class MyRecipeRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Recipe> recipes;

    public MyRecipeRecyclerViewAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
