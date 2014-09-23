package com.davishacks.emote;

public class MoodData {

    // private variables
    public int _id;
    public String _num;

    public MoodData() {
    }

    // constructor
    public MoodData(int id,  String num) {
        this._id = id;
        this._num = num;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getNum() {
        return this._num;
    }

    // setting name
    public void setNum(String num) {
        this._num = num;
    }



}