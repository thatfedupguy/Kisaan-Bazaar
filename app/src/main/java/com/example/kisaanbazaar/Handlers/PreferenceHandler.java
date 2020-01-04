package com.example.kisaanbazaar.Handlers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import static com.example.kisaanbazaar.Utils.Constants.SHARED_PREFERENCES;

public class PreferenceHandler {

    private static final String TAG = PreferenceHandler.class.getSimpleName();
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public PreferenceHandler(Context mContext) {
        prefs = mContext.getSharedPreferences(SHARED_PREFERENCES, 0); // 0 - for private mode
        editor = prefs.edit();
    }


    public void saveInt(String key,int value){
        editor.putInt(key,value);
        editor.apply();
    }
    public int getInt(String key){
        return prefs.getInt(key,-1);
    }



}
