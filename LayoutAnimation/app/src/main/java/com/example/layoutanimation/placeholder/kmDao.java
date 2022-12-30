package com.example.layoutanimation.placeholder;

import org.json.JSONException;
import org.json.JSONObject;

public class kmDao {
    private static final String BASE_URL = "https://swapi.co/api/";
    private static final String PERSON_URL = BASE_URL+"people/";

    public kmObject getPerson(int id){
        final String result = NetworkAdapter.httpRequest(PERSON_URL+id);

        kmObject object = null ;
        try{JSONObject json = new JSONObject(result);
        object = new kmObject(id,json.getString("name"));
        object.setCategory(DrawableResolver.CHARACTER);
        }

        catch(JSONException e){
        e.printStackTrace();
        }
        return object;
    }
}
