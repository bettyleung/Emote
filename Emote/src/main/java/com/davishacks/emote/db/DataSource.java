package com.davishacks.emote.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.davishacks.emote.AppConstants;
import com.davishacks.emote.models.MoodData;

import java.util.ArrayList;
import java.util.List;

public class DataSource implements AppConstants {

    private DatabaseHelper databaseHelper;

    public DataSource(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void close() {
        try {
            databaseHelper.close();
        }
        catch(Exception e) {
            Log.e(LOG_TAG,"EXCEPTION", e);
        }
    }

    // Adding new mood entry
    public void addMoodData(final MoodData moodData) {
        AsyncTask<Void, Void, Void > task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                SQLiteDatabase database = null;
                try {
                    database = databaseHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(MoodTable.KEY_NUM, moodData.getNum());     // get mood number and put it in db's key_num
                    values.put(MoodTable.KEY_ID, moodData.getID());
                    database.insert(MoodTable.TABLE_NAME, null, values);         // Inserting Row

                } catch (Exception e) {
                    Log.e(LOG_TAG,"EXCEPTION", e);
                }
                return null;
            }
        };
        task.execute();

    }

    // Getting All moods
    //modeled after busservice: getbuslines in ucd mobile
    public void getMoodList( final DbResultCallback<MoodData> dbResultCallback){
        AsyncTask<Void, Void, List<MoodData> > task = new AsyncTask<Void, Void, List<MoodData>>() {
            @Override
            protected List<MoodData> doInBackground(Void... voids) {
                List<MoodData> moodDataList = new ArrayList<MoodData>();
                SQLiteDatabase database = null;
                try {
                    moodDataList.clear();
                    String selectQuery = "SELECT  * FROM " + MoodTable.TABLE_NAME;               // Select All Query
                    database = databaseHelper.getWritableDatabase();
                    Cursor cursor = database.rawQuery(selectQuery, null);

                    // looping through all rows and adding to list
                    if (cursor.moveToFirst()) {
                        do {
                            MoodData moodData = new MoodData(cursor.getInt(1));
                            // Adding moods to list
                            moodDataList.add(moodData);

                        } while (cursor.moveToNext());
                    }
                    // return mood list
                    cursor.close();
                    return moodDataList;
                } catch (Exception e) {
                    Log.e(LOG_TAG,"EXCEPTION", e);
                    moodDataList = null;
                }
                return moodDataList;

            }

            @Override
            protected void onPostExecute(List<MoodData> moodData) {

                if(null == moodData) {

                    dbResultCallback.onError();
                }
                else {

                    dbResultCallback.onData(moodData);
                }
            }

        };
        task.execute();
    }

}
