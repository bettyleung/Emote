package com.davishacks.emote.test;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.davishacks.emote.DatabaseHelper;
import com.davishacks.emote.MoodData;
import com.davishacks.emote.MoodTable;


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

    public void testInsertDb(){
        MoodData moodData = new MoodData(1);

        DatabaseHelper dbHelper = new DatabaseHelper(mContext);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MoodTable.KEY_NUM, moodData.getNum());     // get mood number and put it in db's key_num
        values.put(MoodTable.KEY_ID, moodData.getID());
        database.insert(MoodTable.TABLE_MOODS, null, values);         // Inserting Row

    }



}
