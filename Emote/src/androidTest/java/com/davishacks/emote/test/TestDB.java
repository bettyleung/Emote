package com.davishacks.emote.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.davishacks.emote.db.DatabaseHelper;
import com.davishacks.emote.db.MoodTable;
import com.davishacks.emote.models.MoodData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
        try {
            SQLiteDatabase database = null;

            MoodData moodData = new MoodData(1);
            DatabaseHelper databaseHelper = new DatabaseHelper(this.mContext);
            database = databaseHelper.getWritableDatabase();

            ContentValues testValues = new ContentValues();
            testValues.put(MoodTable.KEY_NUM, moodData.getNum());     // get mood number and put it in db's key_num
            testValues.put(MoodTable.KEY_ID, moodData.getID());
            long locationRowId;

            locationRowId = database.insertOrThrow(MoodTable.TABLE_NAME, null, testValues);         // Inserting Row


            assertTrue(locationRowId != -1);

            Cursor cursor = database.query(
                   MoodTable.TABLE_NAME,  // Table to Query
                    null, // all columns
                    null, // Columns for the "where" clause
                    null, // Values for the "where" clause
                    null, // columns to group by
                    null, // columns to filter by row groups
                    null // sort order
            );

            validateCursor(cursor, testValues);
        }
        catch (Exception e){
            //Todo: handle exception
        }



    }

 

    static void validateCursor(Cursor valueCursor, ContentValues expectedValues) {

        assertTrue(valueCursor.moveToFirst());

        Set<Map.Entry<String, Object>> valueSet = expectedValues.valueSet();
        for (Map.Entry<String, Object> entry : valueSet) {
            String columnName = entry.getKey();
            int idx = valueCursor.getColumnIndex(columnName);
            assertFalse(idx == -1);
            String expectedValue = entry.getValue().toString();
            assertEquals(expectedValue, valueCursor.getString(idx));
        }
        valueCursor.close();
    }
}
