package com.example.WeatherApp;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Thinkpad on 7/3/2015.
 */
public class CityPreference {
    SharedPreferences prefs;


    public CityPreference(Activity activity) {
        this.prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return Beijing as the default city
    public String getCity(){
        return prefs.getString("city", "Beijing, CN");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}
