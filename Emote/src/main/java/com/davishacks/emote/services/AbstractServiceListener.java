package com.davishacks.emote.services;

import java.util.List;

/**
 * Created by 1 on 12/5/2014.
 */
public abstract class AbstractServiceListener<T> implements ServiceListener<T> {

    public void onData(T data) {}

    public void onData(List<T> data) {}

    public void onSuccess() {}
}