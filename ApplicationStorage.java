package ir.imansoft.github.feed.viewer;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;

/**
 * Created by ImanX on 5/23/2016.
 * Copyright 2016 Alireza Tarazani. All rights reserved. 
 */
public class ApplicationStorage {


    private static ApplicationStorage instance;
    private static SharedPreferences  sharedPreferences;

    public static final int     DEFAULT_VALUE_INTEGER = 0;
    public static final boolean DEFAULT_VALUE_BOOLEAN = false;
    public static final String  DEFAULT_VALUE_STRING  = null;

    public static ApplicationStorage getDefaultStorage(Context context) {
        if (instance == null) {
            instance = new ApplicationStorage();
            instance.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return instance;
    }

    public static ApplicationStorage getPrivateStorage(SharedPreferences sharedPreferences) {
        if (instance == null) {
            instance = new ApplicationStorage();
            instance.sharedPreferences = sharedPreferences;
        }
        return instance;
    }

    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).commit();
    }

    public void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).commit();
    }

    public void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, DEFAULT_VALUE_BOOLEAN);
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, DEFAULT_VALUE_INTEGER);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, DEFAULT_VALUE_STRING);
    }

    public void removeValue(String key) {
        sharedPreferences.edit().remove(key).commit();
    }

    public void removeValues(String[] values) {
        for (Map.Entry<String, ?> item : sharedPreferences.getAll().entrySet()) {
            for (String key : values) {
                if (item.getKey().equals(key)) {
                    removeValue(key);
                }
            }
        }
    }
    public void removeValues() {
        for (Map.Entry<String, ?> item : sharedPreferences.getAll().entrySet()) {
            removeValue(item.getKey());
        }
    }


}
