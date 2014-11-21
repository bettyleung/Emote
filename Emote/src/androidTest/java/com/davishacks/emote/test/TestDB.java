package com.davishacks.emote.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.davishacks.emote.DatabaseHelper;
import com.davishacks.emote.MoodData;
import com.davishacks.emote.MoodTable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 1 on 11/13/2014.
 */
public class TestDB extends AndroidTestCase {

    public  void testCreateDB() throws Throwable {
        mContext.deleteDatabase(MoodTable.DATABASE_NAME);
        SQLiteDatabase db = new DatabaseHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());
        db.close();
    }
    //TODO write more unit tests to make sure the sql commands work through the sunshine app on udacity, testdb under

    public void testInsertDB(){
        MoodData moodData = new MoodData(1);
        
        // TODO You might try passing in this.mContext as above, if your dbHelper is not getting initialized properly
        DatabaseHelper dbHelper = new DatabaseHelper(mContext);
        
        
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        // TODO remove this line below, it's redundant.
        database = dbHelper.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        values.put(MoodTable.KEY_NUM, moodData.getNum());     // get mood number and put it in db's key_num
        values.put(MoodTable.KEY_ID, moodData.getID());
        database.insert(MoodTable.TABLE_MOODS, null, values);         // Inserting Row

    }

    public void testGetMoodList(){
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        List<MoodData> moodDataList = new ArrayList<MoodData>();
        SQLiteDatabase database = null;
        moodDataList.clear();
        String selectQuery = "SELECT  * FROM " + MoodTable.TABLE_MOODS;               // Select All Query
        database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MoodData moodData = new MoodData(cursor.getInt(1));
                // Adding moods to list
                moodDataList.add(moodData);
            } while (cursor.moveToNext());
        }
        // return mood list
        cursor.close();

    }
}
