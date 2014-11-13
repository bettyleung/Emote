package com.davishacks.emote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler  {
    private SQLiteDatabase database;
    private MySQLiteHelper mySQLiteHelper;
    //https://bitbucket.org/ucdavis/aggie-mobile/src/dd691f8112ed495cd7bfe551eb7536711b11dbee/app/src/main/java/edu/ucdavis/mobile/aggie/MainApplication.java?at=master
    //lin23
    private static Context mContext;



    public DatabaseHandler(Context context) {
        mySQLiteHelper = new MySQLiteHelper(context);
        this.onCreate();
    }

    // Creating Tables
    public void onCreate() {

        mySQLiteHelper.onCreate(database);
    }

    public void close(){ mySQLiteHelper.close(); }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new mood entry
    public void addMoodData(MoodData moodData) {
        SQLiteDatabase SQLiteDB = null;
        try {
            SQLiteDB = mySQLiteHelper.getWritableDatabase();
            SQLiteDB.beginTransaction();
            ContentValues values = new ContentValues();
            values.put(mySQLiteHelper.KEY_NUM, moodData.getNum());     // get mood number and put it in db's key_num
            values.put(mySQLiteHelper.KEY_ID, moodData.getID());
            SQLiteDB.insert(mySQLiteHelper.TABLE_MOODS, null, values);         // Inserting Row
            SQLiteDB.endTransaction();

        }
        catch (Exception e){
            //Todo: handle exception
        }
        finally{
            if(SQLiteDB != null){
                SQLiteDB.endTransaction();
            }
        }

    }

    // Getting All moods
    public List<MoodData> getMoodList(){
        List<MoodData> moodDataList = new ArrayList<MoodData>();
        SQLiteDatabase SQLiteDB = null;
        try {
            moodDataList.clear();
            String selectQuery = "SELECT  * FROM " + mySQLiteHelper.TABLE_MOODS;               // Select All Query
            SQLiteDB = mySQLiteHelper.getWritableDatabase();
            Cursor cursor = SQLiteDB.rawQuery(selectQuery, null);

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
            // TODO: handle exception
            Log.e("all_mood", "" + e);
        }
        return moodDataList;
    }
}
