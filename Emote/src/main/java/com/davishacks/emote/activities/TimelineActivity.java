package com.davishacks.emote.activities;


import android.os.Bundle;

import android.view.View;

import com.davishacks.emote.R;
import com.davishacks.emote.activities.HistoryActivity;

/**
 * Created by David on 5/18/2014.
 */
public class TimelineActivity extends HistoryActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_line);

        //Button button = (Button)findViewById(R.id.button);
        // button.setOnClickListener(this);
    }

}