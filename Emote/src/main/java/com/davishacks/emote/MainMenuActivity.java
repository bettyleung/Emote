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
public class MainMenuActivity extends MoodRecordActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
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
        Log.i("clicks", "You selected the intensity!");
        Intent i=new Intent(MainMenuActivity.this, History.class);
        startActivity(i);
    }
}

