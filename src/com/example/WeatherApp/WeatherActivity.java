package com.example.WeatherApp;

//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.text.InputType;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.EditText;
//
//
//public class WeatherActivity extends Activity {
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_weather);
//        /*
//        * Weather API
//        * http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=c11a8b43d77e4edc71eb76bfe8f78d72
//        * */
//
////        if (savedInstanceState == null) {
////            getFragmentManager().beginTransaction().add(R.id.container, new WeatherFragment()).commit();
////        }
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new WeatherFragment())
//                    .commit();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.weather, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//		/*int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);*/
//        if(item.getItemId() == R.id.change_city){
//            showInputDialog();
//        }
//        return false;
//
//    }
//
//    private void showInputDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Change city");
//        final EditText input = new EditText(this);
//        input.setInputType(InputType.TYPE_CLASS_TEXT);
//        builder.setView(input);
//        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                changeCity(input.getText().toString());
//            }
//        });
//        builder.show();
//    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        if(item.getItemId() == R.id.change_city){
////            showInputDialog();
////        }
////        return false;
////    }
//    //show input dialog method
////    private void showInputDialog(){
////        AlertDialog.Builder builder = new AlertDialog.Builder(this);
////        builder.setTitle("Change city");
////        final EditText input = new EditText(this);
////        input.setInputType(InputType.TYPE_CLASS_TEXT);
////        builder.setView(input);
////        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////                changeCitys(input.getText().toString());
////            }
////        });
////        builder.show();
////    }
////    private void showInputDialog() {
////        //create a alert dialog
////        AlertDialog.Builder builder = new AlertDialog.Builder(this);
////        //set the alert dialog title
////        builder.setTitle("Change city");
////        //create a input text and set its type as text
////        final EditText input = new EditText(this);
////        input.setInputType(InputType.TYPE_CLASS_TEXT);
////    }
//
//    public void changeCity(String city) {
//        WeatherFragment wf = (WeatherFragment)getFragmentManager().findFragmentById(R.id.container);
//        wf.changeCity(city);
//        new CityPreference(this).setCity(city);
//    }
//}

import android.app.Activity;
import android.text.InputType;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class WeatherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new WeatherFragment())
                    .commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
        if(item.getItemId() == R.id.change_city){
            showInputDialog();
        }
        return false;

    }


    private void showInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change city");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void changeCity(String city){
        WeatherFragment wf = (WeatherFragment)getFragmentManager()
                .findFragmentById(R.id.container);
        wf.changeCity(city);
        new CityPreference(this).setCity(city);
    }

}