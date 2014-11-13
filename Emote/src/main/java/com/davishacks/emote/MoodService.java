package com.davishacks.emote;

import android.content.Context;

/**
 * Created by 1 on 11/7/2014.
 */
public class MoodService {

    private static MoodService moodServiceInstance;
    private static DatabaseHandler mDatabaseHandler;

    public static MoodService getIntstance(){

        if(null == moodServiceInstance){
            moodServiceInstance = new MoodService();
            //Todo write up .getInstance().getDataSource();, source: https://bitbucket.org/ucdavis/aggie-mobile/src/dd691f8112ed495cd7bfe551eb7536711b11dbee/app/src/main/java/edu/ucdavis/mobile/aggie/services/FeedService.java?at=master
            mDatabaseHandler = new DatabaseHandler();
        }
        return moodServiceInstance;
    }

    private MoodService(){

    }
}
