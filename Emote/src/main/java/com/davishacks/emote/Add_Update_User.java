package com.davishacks.emote;


import android.app.Activity;
import android.os.Bundle;


public class Add_Update_User extends Activity {
    DatabaseHandler dbHandler = new DatabaseHandler(this);


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
}
