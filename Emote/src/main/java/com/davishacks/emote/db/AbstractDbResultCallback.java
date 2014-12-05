package com.davishacks.emote.db;

import java.util.List;

/**
 * Created by 1 on 12/5/2014.
 */
public abstract class AbstractDbResultCallback<T> implements DbResultCallback<T> {

    public void onData(T data) {}

    public void onData(List<T> data) {}

}
