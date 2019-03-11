package sk.fri.uniza.recyclerviewdemo.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import sk.fri.uniza.recyclerviewdemo.model.Recipe;


/**
 * Created by Martin on 09.03.2017.
 */

public class LoadData {



    public static List<Recipe> loadRecepies(InputStream inputStream) {

        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        List<Recipe> recipe = null;
        try {
            recipe = mapper.readValue(inputStream, new TypeReference<List<Recipe>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipe;
    }

}
