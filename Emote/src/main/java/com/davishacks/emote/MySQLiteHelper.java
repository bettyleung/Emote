package com.davishacks.emote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1 on 11/3/2014.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;                      // Database Version
    public static final String DATABASE_CREATE = "create table if not exists";
    public static final String DATABASE_NAME = "moodDataManager";      // Database Name
    public static final String TABLE_MOODS = "moodData";                // Mood table name
    // Mood Table Columns names
    public static final String KEY_ID = "time";                          //time
    public static final String KEY_NUM = "moodNum  ";                   //int

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_MOOD_TABLE = DATABASE_CREATE + TABLE_MOODS + "("
                + KEY_ID + " PRIMARY KEY (TEXT)," + KEY_NUM + " INT," + ")";
        database.execSQL(CREATE_MOOD_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOODS);
        // Create tables again
        onCreate(db);
    }
}
