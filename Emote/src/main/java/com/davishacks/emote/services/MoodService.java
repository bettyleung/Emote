package com.davishacks.emote.services;

import com.davishacks.emote.models.MoodData;
import com.davishacks.emote.db.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 11/7/2014.
 */
public class MoodService {

    private static MoodService moodServiceInstance;
    private static DataSource mDataSource;

    private MoodService(){


    }

    public static MoodService getIntstance(){

        if(null == moodServiceInstance){
            moodServiceInstance = new MoodService();
            mDataSource = DbService.getInstance().getDataSource();
        }
        return moodServiceInstance;
    }

    public void storeMoodData(MoodData moodData){
        mDataSource.addMoodData(moodData);
    }

    public List<MoodData> listMoodData(final ServiceListener<MoodData> serviceListener){
        List<MoodData> moodDataList = new ArrayList<MoodData>();
        // mDataSource.getMoodList();


        serviceListener.onData(moodDataList);
        return moodDataList;
    }

}
