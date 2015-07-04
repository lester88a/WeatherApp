package com.example.WeatherApp;
//
//import android.app.Fragment;
//import android.graphics.Typeface;
//import android.os.Bundle;
//import android.os.Handler;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//import org.json.JSONObject;
//
//
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;
//import java.util.logging.LogRecord;
//
//
///**
// * Created by Thinkpad on 7/3/2015.
// */
//public class WeatherFragment extends Fragment {
//    //Typeface weatherFont;
//    //Typeface weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
//
//    //Declare the five TextView objects and initialize them in the onCreateView method
//    TextView cityField;
//    TextView updatedField;
//    TextView detailsField;
//    TextView currentTemperatureField;
//    TextView weatherIcon;
//
//    Handler handler;
//    //Handler handler = new Handler();
//
//    public WeatherFragment() {
//        handler = new Handler();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
////        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
//        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
////        updatedField = (TextView)rootView.findViewById(R.id.updated_field);
////        detailsField = (TextView)rootView.findViewById(R.id.details_field);
////        currentTemperatureField = (TextView)rootView.findViewById(R.id.current_temperature_field);
////        weatherIcon = (TextView)rootView.findViewById(R.id.weather_icon);
//        cityField = (TextView)rootView.findViewById(R.id.city_field);
//        updatedField = (TextView)rootView.findViewById(R.id.updated_field);
//        detailsField = (TextView)rootView.findViewById(R.id.details_field);
//        currentTemperatureField = (TextView)rootView.findViewById(R.id.current_temperature_field);
//        weatherIcon = (TextView)rootView.findViewById(R.id.weather_icon);
//
//        //Typeface weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
//        //Typeface font = Typeface.createFromAsset(getAssets(), "weather.ttf");
//
////        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
////        weatherIcon.setTypeface(font);
//
//        return rootView;
//    }
//
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
////        updateWeatherData(new CityPreference(getActivity()).getCity());
////    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
//        //Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
//        //weatherIcon.setTypeface(font);
//        //weatherFont = Typeface.createFromAsset(getActivity().getAssets(),"fonts/weather.ttf");
//        //weatherFont = Typeface.createFromAsset(weatherIcon.getContext().getAssets(), "weather.ttf");
//        //weatherFont = Typeface.createFromAsset(weatherIcon.getContext().getAssets(),"fonts/weather.ttf");
//
////        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
////        weatherIcon.setTypeface(font);
//
//        updateWeatherData(new CityPreference(getActivity()).getCity());
//    }
//
//    /*
//    * In updateWeatherData, we start a new thread and call getJSON on the RemoteFetch class.
//     * If the value returned by getJSON is null, we display an error message to the user.
//     * If it isn't, we invoke the renderWeather method.
//     * Only the main Thread is allowed to update the user interface of an Android app.
//     * Calling Toast or renderWeather directly from the background thread would lead to a runtime error.
//     * That is why we call these methods using the handler's post method.*/
//    private void updateWeatherData(final String city) {
//        new Thread() {
//            public void run() {
//                final JSONObject json = RemoteFetch.getJSON(getActivity(),city);
//
//                if (json == null) {
//                    handler.post(new Runnable() {
//                        public void run() {
//                            Toast.makeText(getActivity(), getActivity().getString(R.string.place_not_found), Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }
//                else {
//                    handler.post(new Runnable() {
//                        public void run() {
//                            renderWeather(json);
//                        }
//                    });
//
//                }
//            }
//        }.start();
//    }
//
//    //renderWeather method
//    /*
//    * The renderWeather method uses the JSON data to update the TextView objects.
//    * The weather node of the JSON response is an array of data. In this tutorial,
//    * we will only be using the first element of the array of weather data.*/
//
//    private void renderWeather(JSONObject json) {
//        try {
//
//            cityField.setText(json.getString("name").toUpperCase(Locale.US) +
//                    ", " +
//                    json.getJSONObject("sys").getString("country"));
//
//            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
//
//            JSONObject main = json.getJSONObject("main");
//
//            //set details text
//            detailsField.setText(details.getString("description").toUpperCase(Locale.US) +
//            "\n" + "Humidity: " + main.getString("humidity") + "%" +
//            "\n" + "Pressure: " + main.getString("pressure" + "hPa"));
//
//            //set current tem text
//            currentTemperatureField.setText(String.format("%.2f", main.getDouble("temp")) + "?");
//
//            //variables for updated text set date format and get the values from JSON
//            DateFormat df = DateFormat.getDateInstance();
//            String updatedOn = df.format(new Date(json.getLong("dt")*1000));
//            //set updated text
//            updatedField.setText("Last update: " + updatedOn);
//
//
//            setWeatherIcon(details.getInt("id"), json.getJSONObject("sys").getLong("sunrise") * 1000,
//                    json.getJSONObject("sys").getLong("sunset") * 1000);
//
//
//        }
//        catch (Exception e) {
//            Log.e("Magic Weather", "One or more fields not found in the JSON data");
//        }
//    }
//
//    //set weather icon method
//    public void setWeatherIcon(int actualID, long sunrise, long sunset) {
//        int id = actualID / 1000;
//        String icon = "";
//        //sunny in day and night
//        if (actualID == 800) {
//            long currentTime = new Date().getTime();
//            //day sunny
//            if (currentTime >= sunrise && currentTime <= sunset) {
//                icon = getActivity().getString(R.string.weather_sunny);
//            }
//            //night sunny
//            else {
//                icon = getActivity().getString(R.string.weather_clear_night);
//            }
//        }
//        else {
//            switch (id) {
//                case 8: icon = getActivity().getString(R.string.weather_cloudy);
//                    break;
//                case 3: icon = getActivity().getString(R.string.weather_drizzle);
//                    break;
//                case 7: icon =getActivity().getString(R.string.weather_foggy);
//                    break;
//                case 5: icon = getActivity().getString(R.string.weather_rainy);
//                    break;
//                case 6: icon = getActivity().getString(R.string.weather_snowy);
//                    break;
//                case 2: icon = getActivity().getString(R.string.weather_thunder);
//                    break;
//            }
//        }
//        weatherIcon.setText(icon);
//    }
//
//    //change city method
//    public void changeCitys(String city) {
//        updateWeatherData(city);
//    }
//}


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Fragment;
import android.widget.ImageView;
import org.json.JSONObject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



public class WeatherFragment extends Fragment {
    //Typeface weatherFont;

    TextView cityField;
    TextView updatedField;
    TextView detailsField;
    TextView currentTemperatureField;
    ImageView weatherIcon;

    Handler handler;

    public WeatherFragment(){
        handler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        cityField = (TextView)rootView.findViewById(R.id.city_field);
        updatedField = (TextView)rootView.findViewById(R.id.updated_field);
        detailsField = (TextView)rootView.findViewById(R.id.details_field);
        currentTemperatureField = (TextView)rootView.findViewById(R.id.current_temperature_field);
        weatherIcon = (ImageView)rootView.findViewById(R.id.weather_icon);

        //weatherIcon.setTypeface(weatherFont);

        return rootView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
        //weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "weather.ttf");
        updateWeatherData(new CityPreference(getActivity()).getCity());
    }


    private void updateWeatherData(final String city){
        new Thread(){
            public void run(){
                final JSONObject json = RemoteFetch.getJSON(getActivity(), city);
                if(json == null){
                    handler.post(new Runnable(){
                        public void run(){
                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    handler.post(new Runnable(){
                        public void run(){
                            renderWeather(json);
                        }
                    });
                }
            }
        }.start();
    }

    private void renderWeather(JSONObject json){
        try {
            cityField.setText(json.getString("name").toUpperCase(Locale.US) +
                    ", " +
                    json.getJSONObject("sys").getString("country"));

            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");
            detailsField.setText(
                    details.getString("description").toUpperCase(Locale.US) +
                            "\n" + "Humidity: " + main.getString("humidity") + "%" +
                            "\n" + "Pressure: " + main.getString("pressure") + " hPa");

            currentTemperatureField.setText(
                    String.format("%.2f", main.getDouble("temp"))+ " \u2103");

            DateFormat df = DateFormat.getDateTimeInstance();
            String updatedOn = df.format(new Date(json.getLong("dt")*1000));
            updatedField.setText("Last update: " + updatedOn + "\n" + "Cteated By: Lester(Li XU)");

            setWeatherIcon(details.getInt("id"),
                    json.getJSONObject("sys").getLong("sunrise") * 1000,
                    json.getJSONObject("sys").getLong("sunset") * 1000);

        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }

    private void setWeatherIcon(int actualId, long sunrise, long sunset){
        int id = actualId / 100;
        String icon = "";
        if(actualId == 800){
            long currentTime = new Date().getTime();
            if(currentTime>=sunrise && currentTime<sunset) {
                icon = getActivity().getString(R.string.weather_sunny);
                weatherIcon.setImageResource(R.drawable.sunny);
            } else {
                icon = getActivity().getString(R.string.weather_clear_night);
                weatherIcon.setImageResource(R.drawable.night);
            }
        } else {
            switch(id) {
                case 2 : icon = getActivity().getString(R.string.weather_thunder);
                    weatherIcon.setImageResource(R.drawable.thunder);
                    break;
                case 3 : icon = getActivity().getString(R.string.weather_drizzle);
                    weatherIcon.setImageResource(R.drawable.drizzle);
                    break;
                case 7 : icon = getActivity().getString(R.string.weather_foggy);
                    weatherIcon.setImageResource(R.drawable.foggy);
                    break;
                case 8 : icon = getActivity().getString(R.string.weather_cloudy);
                    weatherIcon.setImageResource(R.drawable.cloud);
                    break;
                case 6 : icon = getActivity().getString(R.string.weather_snowy);
                    weatherIcon.setImageResource(R.drawable.snow);
                    break;
                case 5 : icon = getActivity().getString(R.string.weather_rainy);
                    weatherIcon.setImageResource(R.drawable.rainy);
                    break;
            }
        }
        //weatherIcon.setText(icon);
        //weatherIcon.setImageResource(R.drawable.nothing);
    }

    public void changeCity(String city){
        updateWeatherData(city);
    }

}