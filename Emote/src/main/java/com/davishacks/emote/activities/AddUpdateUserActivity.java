package com.davishacks.emote.activities;


import android.app.Activity;
import android.os.Bundle;

import com.davishacks.emote.R;
import com.davishacks.emote.db.DataSource;


public class AddUpdateUserActivity extends Activity {
    DataSource dbHandler = new DataSource(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_recorded);
    }


    String called_from = getIntent().getStringExtra("called");
/*
    if (called_from.equalsIgnoreCase("happy")) {

    } else {*/


    // dbHandler.close();
}
