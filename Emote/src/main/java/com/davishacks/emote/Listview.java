package com.davishacks.emote;


import android.os.Bundle;

import android.view.View;
/**
 * Created by David on 5/18/2014.
 */
public class Listview extends History implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        //Button button = (Button)findViewById(R.id.button);
        // button.setOnClickListener(this);
    }

}