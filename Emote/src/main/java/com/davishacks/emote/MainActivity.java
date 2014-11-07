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
    private DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*      ImageButton happyButton = (ImageButton) findViewById(R.id.happybutton);
        happyButton.setOnClickListener(this);*/

        Button button1 = (Button)findViewById(R.id.happybutton);
        button1.setOnClickListener(this);


        Button button2 = (Button)findViewById(R.id.sadbutton);
        button2.setOnClickListener(this);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MoodData happyMoodInstance = new MoodData(1);
                db.Add_MoodNum(happyMoodInstance);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MoodData happyMoodInstance = new MoodData(2);
                db.Add_MoodNum(happyMoodInstance);
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
