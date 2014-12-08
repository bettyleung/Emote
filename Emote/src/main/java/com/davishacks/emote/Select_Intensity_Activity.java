package com.davishacks.emote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

/**
 * Created by Spicycurryman on 5/18/14.\
 * Modified by kzumi13 on 12/4/14.
 */

public class Select_Intensity_Activity extends Activity implements View.OnClickListener {

    SeekBar intensityBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectintensity);

        ImageButton selectbutton = (ImageButton)findViewById(R.id.selectbutton);
        selectbutton.setOnClickListener(this);

        intensityBar = (SeekBar) findViewById(R.id.seekbutton);
        intensityBar.setMax(9);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.activity_main.xml, menu);
        //  return true;
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.i("clicks", "You selected the intensity!");
        //save the current emotion intensity level in selectionPref
        SharedPreferences selectionPref = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        //Store the intensity level in MyData
        SharedPreferences.Editor editor = selectionPref.edit();

        editor.putInt("myIntensity", intensityBar.getProgress());

        Intent i=new Intent(Select_Intensity_Activity.this, Mood_Record_Activity.class);
        startActivity(i);
    }
}

