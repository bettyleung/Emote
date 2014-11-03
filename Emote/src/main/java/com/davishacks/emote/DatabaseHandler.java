package com.davishacks.emote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private final Context myContex;
    private static final int DATABASE_VERSION = 1;                      // Database Version
    private static final String DATABASE_NAME = "moodDataManager";      // Database Name
    private static final String TABLE_MOODS = "moodData";                // Mood table name
    // Mood Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NUM = "number";
    private final ArrayList<MoodData> moodData_list = new ArrayList<MoodData>();

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContex = context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MOOD_TABLE = "CREATE TABLE " + TABLE_MOODS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NUM + " TEXT," + ")";
        db.execSQL(CREATE_MOOD_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOODS);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new mood entry
    public void Add_MoodNum(MoodData moodData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NUM, moodData.getNum());     // get mood number (1 or 2)
        db.insert(TABLE_MOODS, null, values);         // Inserting Row
        db.close(); // Closing database connection
    }

    // Getting single mood
    MoodData Get_MoodNum(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_MOODS, new String[] { KEY_ID,
                        KEY_NUM }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MoodData moodData = new MoodData(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return mood
        cursor.close();
        db.close();
        return moodData;
    }

    // Getting All moods
    public ArrayList<MoodData> Get_Contacts() {
        try {
            moodData_list.clear();
            String selectQuery = "SELECT  * FROM " + TABLE_MOODS;               // Select All Query
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    MoodData moodData = new MoodData();
                    moodData.setID(Integer.parseInt(cursor.getString(0)));
                    moodData.setNum(cursor.getString(1));
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
            Log.e("all_contact", "" + e);
        }
        return moodData_list;
    }

    // Updating single mood
    public int Update_MoodData(MoodData moodData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NUM, moodData.getNum());
        // updating row
        return db.update(TABLE_MOODS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(moodData.getID()) });
    }

    // Deleting single mood
    public void Delete_Contact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MOODS, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    public int Get_Total_MoodData() {           // Getting mood Count
        String countQuery = "SELECT  * FROM " + TABLE_MOODS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return mood
        return cursor.getCount();
    }
}
