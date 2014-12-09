package com.davishacks.emote.test;

import android.test.AndroidTestCase;
import android.util.Log;

import com.davishacks.emote.db.AbstractDbResultCallback;
import com.davishacks.emote.models.MoodData;
import com.davishacks.emote.services.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by 1 on 12/5/2014.
 */

/*
this testfile tests that the
*/

public class TestDataSource extends AndroidTestCase {

    Semaphore semaphore = new Semaphore(0);

    public void testGetMoodData() throws Throwable {

        final List<MoodData> testMoodDataList = new ArrayList<MoodData>();
        //BusStop busStop = new BusStop("B", "{\"lat\": \"38.5436199\",\"direction\": \"S\",\"tag\": \"22274\",\"name\": \"Memorial Union & East Island\",\"lng\": \"-121.74957\"}");


        DbService.getInstance().getDataSource().getMoodList(new AbstractDbResultCallback<MoodData>() {
            //get mood list is from datasource
            @Override
            public void onData(List<MoodData> moodData) {
                testMoodDataList.addAll(moodData);
                semaphore.release();
            }

            @Override
            public void onError() {
                semaphore.release();
            }

        });

        semaphore.acquire();
        Log.i("woohoo", testMoodDataList.toString());
        assertNotNull(testMoodDataList);
        assertTrue(testMoodDataList.size() > 0);
    }


}
