package com.davishacks.emote;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MoodData {
    // private variables
    private String _timeId;     //moods are differentiated by the time time
    private int _num;

    // constructor
    public MoodData(int id) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this._num = id;
        Calendar cal = Calendar.getInstance();
        _timeId = dateFormat.format(cal.getTime());
    }

    // getting time
    public String getID() {
        return this._timeId;
    }

    // setting time
    public void setID(String id) {
        this._timeId = id;
    }

    // getting mood
    public int getNum() {
        return this._num;
    }

    // setting mood
    public void setNum(int num) {
        this._num = num;
    }



}