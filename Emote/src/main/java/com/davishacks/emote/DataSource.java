package com.davishacks.emote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private DatabaseHelper databaseHelper;

    public DataSource(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void close() {
        try {
            databaseHelper.close();
        }
        catch(Exception e) {
            //Todo: handle exception
        }
    }

    // Adding new mood entry
    public void addMoodData(MoodData moodData) {

        SQLiteDatabase database = null;
        try {
            database = databaseHelper.getWritableDatabase();
            database.beginTransaction();
            ContentValues values = new ContentValues();
            values.put(MoodTable.KEY_NUM, moodData.getNum());     // get mood number and put it in db's key_num
            values.put(MoodTable.KEY_ID, moodData.getID());
            database.insert(MoodTable.TABLE_MOODS, null, values);         // Inserting Row
            database.endTransaction();
        }
        catch (Exception e){
            //Todo: handle exception
        }
        finally{
            if(database != null){
                database.endTransaction();
            }
        }

    }

    // Getting All moods
    public List<MoodData> getMoodList(){
        List<MoodData> moodDataList = new ArrayList<MoodData>();
        SQLiteDatabase database = null;
        try {
            moodDataList.clear();
            String selectQuery = "SELECT  * FROM " + MoodTable.TABLE_MOODS;               // Select All Query
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
            // TODO: handle exception
        }
        return moodDataList;
    }
}
