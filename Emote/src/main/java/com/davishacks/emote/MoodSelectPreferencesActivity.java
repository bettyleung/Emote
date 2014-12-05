package com.davishacks.emote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MoodSelectPreferencesActivity extends Activity implements View.OnClickListener{

    CheckBox select1CBox;
    CheckBox select2CBox;
    CheckBox select3CBox;
    CheckBox select4CBox;
    CheckBox select5CBox;
    CheckBox select6CBox;
    Spinner mood1Spinner;
    Spinner mood2Spinner;
    Spinner mood3Spinner;
    Spinner mood4Spinner;
    Spinner mood5Spinner;
    Spinner mood6Spinner;
    Spinner color1Spinner;
    Spinner color2Spinner;
    Spinner color3Spinner;
    Spinner color4Spinner;
    Spinner color5Spinner;
    Spinner color6Spinner;

    //String[] moodsArray;

    Button saveBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_select_preferences);

        select1CBox = (CheckBox) findViewById(R.id.cBox_select1);
        select2CBox = (CheckBox) findViewById(R.id.cBox_select2);
        select3CBox = (CheckBox) findViewById(R.id.cBox_select3);
        select4CBox = (CheckBox) findViewById(R.id.cBox_select4);
        select5CBox = (CheckBox) findViewById(R.id.cBox_select5);
        select6CBox = (CheckBox) findViewById(R.id.cBox_select6);

        mood1Spinner = (Spinner) findViewById(R.id.spinner_mood1);
        mood2Spinner = (Spinner) findViewById(R.id.spinner_mood2);
        mood3Spinner = (Spinner) findViewById(R.id.spinner_mood3);
        mood4Spinner = (Spinner) findViewById(R.id.spinner_mood4);
        mood5Spinner = (Spinner) findViewById(R.id.spinner_mood5);
        mood6Spinner = (Spinner) findViewById(R.id.spinner_mood6);

        color1Spinner = (Spinner) findViewById(R.id.spinner_color1);
        color2Spinner = (Spinner) findViewById(R.id.spinner_color2);
        color3Spinner = (Spinner) findViewById(R.id.spinner_color3);
        color4Spinner = (Spinner) findViewById(R.id.spinner_color4);
        color5Spinner = (Spinner) findViewById(R.id.spinner_color5);
        color6Spinner = (Spinner) findViewById(R.id.spinner_color6);

        //Resources res = getResources();
       //moodsArray = res.getStringArray(R.array.moods_array);

        ArrayAdapter<CharSequence> moodSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.moods_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        moodSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mood1Spinner.setAdapter(moodSpinnerAdapter);
        mood2Spinner.setAdapter(moodSpinnerAdapter);
        mood3Spinner.setAdapter(moodSpinnerAdapter);
        mood4Spinner.setAdapter(moodSpinnerAdapter);
        mood5Spinner.setAdapter(moodSpinnerAdapter);
        mood6Spinner.setAdapter(moodSpinnerAdapter);

        ArrayAdapter<CharSequence> colorSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.colors_string, android.R.layout.simple_spinner_item);
        colorSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color1Spinner.setAdapter(colorSpinnerAdapter);
        color2Spinner.setAdapter(colorSpinnerAdapter);
        color3Spinner.setAdapter(colorSpinnerAdapter);
        color4Spinner.setAdapter(colorSpinnerAdapter);
        color5Spinner.setAdapter(colorSpinnerAdapter);
        color6Spinner.setAdapter(colorSpinnerAdapter);



        saveBtn = (Button) findViewById(R.id.btn_save);

        //get sharePreferences -------------------------------------------------------------
        updatePreferences();

        saveBtn.setOnClickListener(this);
    }

    //Here is a test function for sharedPreferences

    public void save(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Save if button is clickable/visible
        editor.putBoolean("cBox1", select1CBox.isChecked());
        editor.putBoolean("cBox2", select2CBox.isChecked());
        editor.putBoolean("cBox3", select3CBox.isChecked());
        editor.putBoolean("cBox4", select4CBox.isChecked());
        editor.putBoolean("cBox5", select5CBox.isChecked());
        editor.putBoolean("cBox6", select6CBox.isChecked());

        //Save mood seleciton
        editor.putInt("mood1", mood1Spinner.getSelectedItemPosition());
        editor.putInt("mood2", mood2Spinner.getSelectedItemPosition());
        editor.putInt("mood3", mood3Spinner.getSelectedItemPosition());
        editor.putInt("mood4", mood4Spinner.getSelectedItemPosition());
        editor.putInt("mood5", mood5Spinner.getSelectedItemPosition());
        editor.putInt("mood6", mood6Spinner.getSelectedItemPosition());

        //Save Color selection
        editor.putInt("color1", color1Spinner.getSelectedItemPosition());
        editor.putInt("color2", color2Spinner.getSelectedItemPosition());
        editor.putInt("color3", color3Spinner.getSelectedItemPosition());
        editor.putInt("color4", color4Spinner.getSelectedItemPosition());
        editor.putInt("color5", color5Spinner.getSelectedItemPosition());
        editor.putInt("color6", color6Spinner.getSelectedItemPosition());


        editor.commit();
        //Toast.makeText(this, "Data was successfully saved ", Toast.LENGTH_LONG).show();
    }

    /*
    public void load(View view){
        updatePreferences();
    }
    */

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mood_select_preferences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),
                "Preferences Saved", Toast.LENGTH_LONG).show();
        save(v);
    }

    private void updatePreferences(){
        //sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        //set checkboxes
        select1CBox.setChecked(sharedPreferences.getBoolean("cBox1", false));
        select2CBox.setChecked(sharedPreferences.getBoolean("cBox2", false));
        select3CBox.setChecked(sharedPreferences.getBoolean("cBox3", false));
        select4CBox.setChecked(sharedPreferences.getBoolean("cBox4", false));
        select5CBox.setChecked(sharedPreferences.getBoolean("cBox5", false));
        select6CBox.setChecked(sharedPreferences.getBoolean("cBox6", false));

        //set the mood spinners
        mood1Spinner.setSelection(sharedPreferences.getInt("mood1", 0));
        mood2Spinner.setSelection(sharedPreferences.getInt("mood2", 1));
        mood3Spinner.setSelection(sharedPreferences.getInt("mood3", 2));
        mood4Spinner.setSelection(sharedPreferences.getInt("mood4", 3));
        mood5Spinner.setSelection(sharedPreferences.getInt("mood5", 4));
        mood6Spinner.setSelection(sharedPreferences.getInt("mood6", 5));

        //set the color spinners
        color1Spinner.setSelection(sharedPreferences.getInt("color1", 4));
        color2Spinner.setSelection(sharedPreferences.getInt("color2", 2));
        color3Spinner.setSelection(sharedPreferences.getInt("color3", 11));
        color4Spinner.setSelection(sharedPreferences.getInt("color4", 1));
        color5Spinner.setSelection(sharedPreferences.getInt("color5", 3));
        color6Spinner.setSelection(sharedPreferences.getInt("color6", 8));
    }
}
