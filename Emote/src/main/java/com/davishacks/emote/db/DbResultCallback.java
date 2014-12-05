package com.davishacks.emote.db;

import java.util.List;

/**
 * Created by 1 on 12/4/2014.
 */
public interface DbResultCallback<T> {
    public void onData(T data);
    public void onData(List<T> data);
    public void onError();
}
