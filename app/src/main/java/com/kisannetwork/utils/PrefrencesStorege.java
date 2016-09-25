package com.kisannetwork.utils;

import android.content.Context;
import android.content.SharedPreferences;


 public class PrefrencesStorege {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PrefrencesStorege(Context context)
    {
        sharedPreferences=context.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public  void saveStringData(String key, String value)
    {
        editor.putString(key,value);
        editor.commit();
    }

    public String getStringData(String key)
    {
       return sharedPreferences.getString(key,"");
    }



}
