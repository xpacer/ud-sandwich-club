package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    private static final String NAME_KEY = "name";
    private static final String MAIN_NAME_KEY = "mainName";
    private static final String ALIAS_KEY = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN_KEY = "placeOfOrigin";
    private static final String DESCRIPTION_KEY = "description";
    private static final String IMAGE_KEY = "image";
    private static final String INGREDIENTS_KEY = "ingredients";


    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichJson = new JSONObject(json);

        Sandwich sandwich = new Sandwich();

        JSONObject sandwichName = sandwichJson.getJSONObject(NAME_KEY);

        String mainName = sandwichName.getString(MAIN_NAME_KEY);
        sandwich.setMainName(mainName);

        JSONArray aliasJson = sandwichName.getJSONArray(ALIAS_KEY);

        ArrayList<String> aliasList = new ArrayList<>();

        for (int i = 0; i < aliasJson.length(); i++) {
            aliasList.add(aliasJson.getString(i));
        }

        sandwich.setAlsoKnownAs(aliasList);

        String placeOfOrigin = sandwichJson.getString(PLACE_OF_ORIGIN_KEY);
        sandwich.setPlaceOfOrigin(placeOfOrigin);

        String description = sandwichJson.getString(DESCRIPTION_KEY);
        sandwich.setDescription(description);

        String image = sandwichJson.getString(IMAGE_KEY);
        sandwich.setImage(image);

        JSONArray ingredientsJson = sandwichJson.getJSONArray(INGREDIENTS_KEY);

        ArrayList<String> ingredientsList = new ArrayList<>();

        for (int i = 0; i < ingredientsJson.length(); i++) {
            ingredientsList.add(ingredientsJson.getString(i));
        }

        sandwich.setIngredients(ingredientsList);


        return sandwich;
    }
}
