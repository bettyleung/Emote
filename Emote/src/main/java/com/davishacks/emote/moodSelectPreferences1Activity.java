package com.davishacks.emote;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;


public class MoodSelectPreferences1Activity extends PreferenceActivity implements Preference.OnPreferenceChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.activity_mood_select_preferences1);


    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        return false;
    }
}
