package com.davishacks.emote.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 1 on 11/3/2014.
 */
public class MoodTable {

    public static final int DATABASE_VERSION = 4;                                // Database Version
    public static final String DATABASE_CREATE = "create table if not exists ";
    public static final String DATABASE_NAME = "emote.db";                // Database Name
    public static final String TABLE_NAME = "moods";                         // Mood table name
    // Mood Table Columns names
    public static final String KEY_ID = "time";                                  //time
    public static final String KEY_NUM = "moodNum  ";                            //int

    public MoodTable(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onCreate(SQLiteDatabase database) {
        String CREATE_MOOD_TABLE = DATABASE_CREATE + TABLE_NAME + " ( "
                + KEY_ID + " TEXT PRIMARY KEY, " + KEY_NUM + " INT" + " )";
        database.execSQL(CREATE_MOOD_TABLE);

    }

    // Upgrading database
    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
}
