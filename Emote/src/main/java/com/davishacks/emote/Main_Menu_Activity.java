package com.davishacks.emote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by Betty Leung on 5/18/14.
 */
public class Main_Menu_Activity extends Mood_Record_Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
/*
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);*/


        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);


        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent1 = new Intent(Main_Menu_Activity.this,MainActivity.class);
                startActivity(myintent1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent2 = new Intent(Main_Menu_Activity.this,History.class);
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

/*    @Override
    public void onClick(View v) {
        Log.i("clicks", "You selected the intensity!");
        Intent i=new Intent(Main_Menu_Activity.this, History.class);
        startActivity(i);
    }*/
}

