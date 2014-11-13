package com.davishacks.emote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 11/7/2014.
 */
public class MoodService {

    private static MoodService moodServiceInstance;
    private static DatabaseHandler moodServiceDatabaseHandler;
    private static MainApplication mMainApplication;

    private MoodService(){

    }

    public static MoodService getIntstance(){

        if(null == moodServiceInstance){
            moodServiceInstance = new MoodService();
            //Todo write up .getInstance().getDataSource();, source: https://bitbucket.org/ucdavis/aggie-mobile/src/dd691f8112ed495cd7bfe551eb7536711b11dbee/app/src/main/java/edu/ucdavis/mobile/aggie/services/FeedService.java?at=master
            moodServiceDatabaseHandler = mMainApplication.getDatabaseHandler();
        }
        return moodServiceInstance;
    }

    public void storeMoodData(MoodData moodData){
        moodServiceDatabaseHandler.addMoodData(moodData);
    }

    public List<MoodData> listMoodData(){
        List<MoodData> moodDataList = new ArrayList<MoodData>();
        moodDataList = moodServiceDatabaseHandler.getMoodList();
        return moodDataList;
    }

}
