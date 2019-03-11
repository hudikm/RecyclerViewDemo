package sk.fri.uniza.recyclerviewdemo.model;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import sk.fri.uniza.recyclerviewdemo.utilities.LoadData;

public class RecipesDataSet {

    public static List<Recipe> getRecipes(Context context) {
        if (recipes == null) {
            try {
                // Load Data from file
                InputStream openFile = context.getAssets().open("recepty.json");
                recipes = LoadData.loadRecepies(openFile);
                Recipe.setContext(context);
                Log.d("CookBook", String.valueOf(recipes.size()));

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("CookBook", "Data read error");
            }
        }
        return recipes;
    }

    private static List<Recipe> recipes = null;

}
