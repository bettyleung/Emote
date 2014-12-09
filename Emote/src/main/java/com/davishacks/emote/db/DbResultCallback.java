package com.davishacks.emote.db;

import java.util.List;

/**
 * Created by 1 on 12/4/2014.
 */
//synonymous with servicelistener in aggie mobile
public interface DbResultCallback<T> {
    public void onData(T data);

    public void onData(List<T> data);

    public void onError();
}
