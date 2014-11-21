package com.davishacks.emote;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.davishacks.emote.activities.MainMenuActivity;

/**
 * Created by Betty Leung on 5/18/14.
 */
public class History extends MainMenuActivity implements View.OnClickListener {

    int test_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        Button timelineViewBtn = (Button)findViewById(R.id.button);
        timelineViewBtn.setOnClickListener(this);


        Button listViewBtn = (Button)findViewById(R.id.button2);
        listViewBtn.setOnClickListener(this);

        timelineViewBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent1 = new Intent(History.this, Timeline.class);
                startActivity(myintent1);

            }
        });
        listViewBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent2 = new Intent(History.this, Listview.class);
                startActivity(myintent2);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.activity_main.xml, menu);
        //  return true;
        return true;
    }


}

