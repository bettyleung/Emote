package com.davishacks.emote.test;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.davishacks.emote.MySQLiteHelper;


/**
 * Created by 1 on 11/13/2014.
 */
public class TestDB extends AndroidTestCase {

    public  void testCreateDB() throws Throwable {
        mContext.deleteDatabase(MySQLiteHelper.DATABASE_NAME);
        SQLiteDatabase db = new MySQLiteHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());
        db.close();
    }
}
