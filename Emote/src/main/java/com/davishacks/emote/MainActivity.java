package com.davishacks.emote;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {

    ListView moodListView;
    ArrayList<MoodData> moodArrayList = new ArrayList<MoodData>();
    // Todo turn this into a singleton
    private DatabaseHandler db = new DatabaseHandler(this);
    //Todo replace all calls to db with mMoodService (instead of calling db directly, layer of abstraction)
    private MoodService  mMoodService = MoodService.getIntstance();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*      ImageButton happyButton = (ImageButton) findViewById(R.id.happybutton);
        happyButton.setOnClickListener(this);*/

        Button btnHappy = (Button)findViewById(R.id.happybutton);
        btnHappy.setOnClickListener(this);


        Button btnSad = (Button)findViewById(R.id.sadbutton);
        btnSad.setOnClickListener(this);

        btnHappy.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MoodData happyMoodInstance = new MoodData(1);
                db.addMoodNum(happyMoodInstance);
                finish();
            }
        });
        btnSad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MoodData happyMoodInstance = new MoodData(2);
                db.addMoodNum(happyMoodInstance);
                finish();
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

    @Override
    public void onClick(View v) {

        Intent i=new Intent(MainActivity.this, MoodRecordActivity.class);
        startActivity(i);
    }
}
