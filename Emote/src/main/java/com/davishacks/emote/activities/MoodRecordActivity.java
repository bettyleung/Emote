package com.davishacks.emote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.davishacks.emote.R;

/**
 * Created by Spicycurryman on 5/18/14.
 */
public class MoodRecordActivity extends SelectIntensityActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_recorded);

        Button mainMenuBtn = (Button) findViewById(R.id.button);
        mainMenuBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.i("clicks", "You selected the intensity!");
        Intent i=new Intent(MoodRecordActivity.this, MainMenuActivity.class);
        startActivity(i);
    }


}




