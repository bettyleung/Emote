package com.davishacks.emote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button selectBtn1;
    Button selectBtn2;
    Button selectBtn3;
    Button selectBtn4;
    Button selectBtn5;
    Button selectBtn6;
    String[] moodsArray;
    int[] colorArray;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        selectBtn1 = (Button) findViewById(R.id.btn_select_1);
        selectBtn2 = (Button) findViewById(R.id.btn_select_2);
        selectBtn3 = (Button) findViewById(R.id.btn_select_3);
        selectBtn4 = (Button) findViewById(R.id.btn_select_4);
        selectBtn5 = (Button) findViewById(R.id.btn_select_5);
        selectBtn6 = (Button) findViewById(R.id.btn_select_6);

        selectBtn1.setOnClickListener(this);
        selectBtn2.setOnClickListener(this);
        selectBtn3.setOnClickListener(this);
        selectBtn4.setOnClickListener(this);
        selectBtn5.setOnClickListener(this);
        selectBtn6.setOnClickListener(this);

        Resources res = getResources();
        moodsArray = res.getStringArray(R.array.moods_array);
        colorArray = res.getIntArray(R.array.colors);
    }


    @Override
    protected void onResume() {

        //onResume, we want to update our button preferences
        setButtonsToPreferences();

        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.activity_main.xml, menu);
      //  return true;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        //switch statement if we add more items
        switch(item.getItemId()) {
            case R.id.action_settings:
                settingsMenuItem();
        }
        return true;
    }

    //If the settings item is selected in the menu, do this
    private void settingsMenuItem(){
        Log.i("clicks", "Settings Menu");
        Intent i = new Intent(MainActivity.this, MoodSelectPreferences1Activity.class);
        startActivity(i);
    }

    //Set onClick Listener for Mood selection buttons
    @Override
    public void onClick(View v) {

        //TODO: implement buttons stuffs
        if(v == selectBtn1) {
            Log.i("clicks", "You selected a color!");
            Intent i = new Intent(MainActivity.this, Select_Intensity_Activity.class);
            startActivity(i);
        }
        else if(v == selectBtn2){
            Log.i("clicks", "You selected a color!");
            Intent i = new Intent(MainActivity.this, Select_Intensity_Activity.class);
            startActivity(i);
        }
        else if(v == selectBtn3){
            Log.i("clicks", "You selected a color!");
            Intent i = new Intent(MainActivity.this, Select_Intensity_Activity.class);
            startActivity(i);
        }
        else if(v == selectBtn4){
            Log.i("clicks", "You selected a color!");
            Intent i = new Intent(MainActivity.this, Select_Intensity_Activity.class);
            startActivity(i);
        }
        else if(v == selectBtn5){
            Log.i("clicks", "You selected a color!");
            Intent i = new Intent(MainActivity.this, Select_Intensity_Activity.class);
            startActivity(i);
        }
        else if(v == selectBtn6){
            Log.i("clicks", "You selected a color!");
            Intent i = new Intent(MainActivity.this, Select_Intensity_Activity.class);
            startActivity(i);
        }
    }

    //Set all of the mood selections buttons to the users preferences
    public void setButtonsToPreferences(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        //sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("cBox1", false)) {
            selectBtn1.setVisibility(View.VISIBLE);
            selectBtn1.setClickable(true);
            selectBtn1.setText(moodsArray[sharedPreferences.getInt("mood1",0)]);
            selectBtn1.setBackgroundColor(colorArray[sharedPreferences.getInt("color1", 4)]);
        }
        else {
            selectBtn1.setVisibility(View.INVISIBLE);
            selectBtn1.setClickable(false);
        }
        if(sharedPreferences.getBoolean("cBox2", false)) {
            selectBtn2.setVisibility(View.VISIBLE);
            selectBtn2.setClickable(true);
            selectBtn2.setText(moodsArray[sharedPreferences.getInt("mood2",1)]);
            selectBtn2.setBackgroundColor(colorArray[sharedPreferences.getInt("color2", 2)]);
        }
        else {
            selectBtn2.setVisibility(View.INVISIBLE);
            selectBtn2.setClickable(false);
        }
        if(sharedPreferences.getBoolean("cBox3", false)) {
            selectBtn3.setVisibility(View.VISIBLE);
            selectBtn3.setClickable(true);
            selectBtn3.setText(moodsArray[sharedPreferences.getInt("mood3",2)]);
            selectBtn3.setBackgroundColor(colorArray[sharedPreferences.getInt("color3", 11)]);
        }
        else {
            selectBtn3.setVisibility(View.INVISIBLE);
            selectBtn3.setClickable(false);
        }
        if(sharedPreferences.getBoolean("cBox4", false)) {
            selectBtn4.setVisibility(View.VISIBLE);
            selectBtn4.setClickable(true);
            selectBtn4.setText(moodsArray[sharedPreferences.getInt("mood4",3)]);
            selectBtn4.setBackgroundColor(colorArray[sharedPreferences.getInt("color4", 1)]);
        }
        else {
            selectBtn4.setVisibility(View.INVISIBLE);
            selectBtn4.setClickable(false);
        }
        if(sharedPreferences.getBoolean("cBox5", false)) {
            selectBtn5.setVisibility(View.VISIBLE);
            selectBtn5.setClickable(true);
            selectBtn5.setText(moodsArray[sharedPreferences.getInt("mood5",4)]);
            selectBtn5.setBackgroundColor(colorArray[sharedPreferences.getInt("color5", 3)]);
        }
        else {
            selectBtn5.setVisibility(View.INVISIBLE);
            selectBtn5.setClickable(false);
        }
        if(sharedPreferences.getBoolean("cBox6", false)) {
            selectBtn6.setVisibility(View.VISIBLE);
            selectBtn6.setClickable(true);
            selectBtn6.setText(moodsArray[sharedPreferences.getInt("mood6",5)]);
            selectBtn6.setBackgroundColor(colorArray[sharedPreferences.getInt("color6", 8)]);
        }
        else {
            selectBtn6.setVisibility(View.INVISIBLE);
            selectBtn6.setClickable(false);
        }
    }
}
