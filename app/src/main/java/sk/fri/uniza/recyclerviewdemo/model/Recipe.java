package sk.fri.uniza.recyclerviewdemo.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "ingredients",
        "detail",
        "image_url"
})
public class Recipe {

    @JsonIgnore
    private static Context contex = null;
    @JsonProperty("title")
    public String title;
    @JsonProperty("ingredients")
    public List<String> ingredients = null;
    @JsonProperty("detail")
    public String detail;
    @JsonProperty("image_url")
    public String imageUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonIgnore
    public static void setContext(Context appcontext) {
        contex = appcontext;
    }

    @JsonIgnore
    public Bitmap getBitmapFromAsset() {
        assert contex != null;
        return getBitmapFromAsset(contex);
    }

    @JsonIgnore
    public Bitmap getBitmapFromAsset(Context context) {
        AssetManager assetManager = context.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(imageUrl);
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}