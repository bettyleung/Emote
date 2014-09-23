package com.davishacks.emote;


import android.os.Bundle;

import android.view.View;
/**
 * Created by David on 5/18/2014.
 */
public class Timeline extends History implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_line);

        //Button button = (Button)findViewById(R.id.button);
        // button.setOnClickListener(this);
    }

}