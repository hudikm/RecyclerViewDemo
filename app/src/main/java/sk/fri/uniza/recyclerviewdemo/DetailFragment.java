package sk.fri.uniza.recyclerviewdemo;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sk.fri.uniza.recyclerviewdemo.model.Recipe;
import sk.fri.uniza.recyclerviewdemo.model.RecipesDataSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private int position;
    private static final String POS_TAG = "POSITION";

    public DetailFragment() {

    }

    public static DetailFragment createDetailFragment(int position) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POS_TAG, position);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load position from arguments
        assert getArguments() != null;
        position = getArguments().getInt(POS_TAG, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView img = getView().findViewById(R.id.detailImage);
        TextView title = getView().findViewById(R.id.recipeTitle);
        TextView detail = getView().findViewById(R.id.recipeDetail);
        TextView ingredients = getView().findViewById(R.id.recipeIngred);

        Recipe recipe = RecipesDataSet.getRecipes(getContext()).get(position);

        img.setImageBitmap(recipe.getBitmapFromAsset());
        title.setText(recipe.title);
        detail.setText(recipe.detail);

        String ingred = TextUtils.join("\n\r", recipe.ingredients);
        ingredients.setText(ingred);


    }
}
