package com.novikov.cuintertables.CounterClass;

import android.content.SharedPreferences;
import android.util.Log;

import com.novikov.cuintertables.Interface.ILoging;

public class CounterSave implements ILoging {


    public void SaveCounter(String NameSettings, SharedPreferences mSettings, int Counter){


        try {
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putInt(NameSettings, Counter);
            editor.apply();

            Log.d(TAG, "Успешно записанно!");

        } catch (Exception e) {

            Log.d(TAG, "Не удалось записать!" + e);
            e.printStackTrace();
        }



    }

    public int ReadCounter(String NameSettings, SharedPreferences mSettings,  int Counter) {


        try {
            if (mSettings.contains(NameSettings)) {
                Counter = mSettings.getInt(NameSettings, 0);

            }

            Log.d(TAG, "Успешно загружено!");


        } catch (Exception e) {
            Log.d(TAG, "Не удалось загрузить!" + e);
            e.printStackTrace();
        }

        return Counter;

    }

}
