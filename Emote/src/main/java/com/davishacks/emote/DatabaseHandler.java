package com.davishacks.emote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHandler  {
    private SQLiteDatabase database;
    private MySQLiteHelper db;
    public final ArrayList<MoodData> moodData_list = new ArrayList<MoodData>();

    public DatabaseHandler(Context context) {
     db = new MySQLiteHelper(context);
     this.onCreate();   
    }

    // Creating Tables
    public void onCreate() {
        String CREATE_MOOD_TABLE = "CREATE TABLE " + db.TABLE_MOODS + "("
                + db.KEY_ID + " PRIMARY KEY (TEXT)," + db.KEY_NUM + " INT," + ")";
        db.onCreate(database);
        db.onCreateHelper(database, CREATE_MOOD_TABLE);
    }

    public void close(){ db.close(); }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new mood entry
    public void Add_MoodNum(MoodData moodData) {
        SQLiteDatabase database1 = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(db.KEY_NUM, moodData.getNum());     // get mood number (1 or 2)
        database1.insert(db.TABLE_MOODS, null, values);         // Inserting Row
        database1.close(); // Closing database connection
    }

    // Getting All moods
    public ArrayList<MoodData> getMoods() {
        try {
            moodData_list.clear();
            String selectQuery = "SELECT  * FROM " + db.TABLE_MOODS;               // Select All Query
            SQLiteDatabase database1 = db.getWritableDatabase();
            Cursor cursor = database1.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    MoodData moodData = new MoodData(cursor.getInt(1));
                    // Adding moods to list
                    moodData_list.add(moodData);
                } while (cursor.moveToNext());
            }
            // return mood list
            cursor.close();
            db.close();
            return moodData_list;
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("all_mood", "" + e);
        }
        return moodData_list;
    }
}
