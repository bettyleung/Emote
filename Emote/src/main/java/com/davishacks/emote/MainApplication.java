package com.davishacks.emote;

import android.app.Application;
import android.content.Context;

/**
 * Created by 1 on 11/13/2014.
 */
public class MainApplication extends Application{

    private static Context mContext;
    private static DatabaseHandler mainApplicationDatabaseHandler; //singleton

    @Override
    public void onCreate(){
        super.onCreate();
        MainApplication.mContext = getApplicationContext();
        MainApplication.mainApplicationDatabaseHandler = new DatabaseHandler(mContext);
    }

    public static Context getAppContext(){
        return MainApplication.mContext;
    }

    public DatabaseHandler getDatabaseHandler(){
        return mainApplicationDatabaseHandler;
    }

}
