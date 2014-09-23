package com.davishacks.emote;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {

    ListView moodListView;
    ArrayList<MoodData> moodArrayList = new ArrayList<MoodData>();
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton selectbutton = (ImageButton) findViewById(R.id.selectbutton);
        selectbutton.setOnClickListener(this);
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
        Log.i("clicks", "You selected a color!");
        Intent i=new Intent(MainActivity.this, Mood_Record_Activity.class);
        startActivity(i);
    }
}
