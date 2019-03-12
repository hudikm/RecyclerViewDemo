package sk.fri.uniza.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sk.fri.uniza.recyclerviewdemo.model.Recipe;

public class MyRecipeRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Recipe> recipes;
    private OnRecipeListInteraction mListener;

    public MyRecipeRecyclerViewAdapter(List<Recipe> recipes, OnRecipeListInteraction mListener) {
        this.recipes = recipes;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_recipe_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.contentText.setText(recipes.get(i).title);
        viewHolder.smallImageView.setImageBitmap(recipes.get(i).getBitmapFromAsset());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRecipeClick(i);
                Map<String, Integer> nameMap = new HashMap<>();
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    /**
     * This interface must be implemented by activities that contain this
     * recycleview to allow an interaction.
     */
    public interface OnRecipeListInteraction {
        void onRecipeClick(int position);


    }
}
