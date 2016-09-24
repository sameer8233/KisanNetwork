package com.kisannetwork.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sameer on 7/9/2016.
 */
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

    public  void saveIntData(String key, int value)
    {
        editor.putInt(key, value);
        editor.commit();
    }

    public  void saveDoubleData(String key, double value)
    {
        editor.putLong(key, Double.doubleToLongBits(value));
        editor.commit();
    }

    public String getStringData(String key)
    {
       return sharedPreferences.getString(key,"");
    }

    public int getIntData(String key)
    {
        return sharedPreferences.getInt(key, 0);
    }

    public Double getDoubleData(String key)
    {
        return Double.longBitsToDouble(sharedPreferences.getLong(key, Double.doubleToLongBits(0)));
    }

}
