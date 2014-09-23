package com.davishacks.emote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Spicycurryman on 5/18/14.
 */
public class Mood_Record_Activity extends Select_Intensity_Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_recorded);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.i("clicks", "You selected the intensity!");
        Intent i=new Intent(Mood_Record_Activity.this, Main_Menu_Activity.class);
        startActivity(i);
    }


    }




