package com.vats.kapil_assignment.data;

import android.content.Context;

import com.google.gson.Gson;
import com.vats.kapil_assignment.model.ProductResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Kapil on 10/12/2015.
 */
public class ResponseParser {

    private Context mContext;

    public ResponseParser(Context context) {
        this.mContext = context;
    }

    public ProductResponse parse() throws IOException {

        Gson gson = new Gson();
        InputStreamReader inputStreamReader = null;
        try{
            InputStream inputstream = mContext.getAssets().open("input.json");
            inputStreamReader = new InputStreamReader(inputstream);
            return gson.fromJson(inputStreamReader, ProductResponse.class);
        }finally {
            if(inputStreamReader!=null){
                inputStreamReader.close();
            }
        }



    }
}
