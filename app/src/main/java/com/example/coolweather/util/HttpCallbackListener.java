package com.example.coolweather.util;

/**
 * Created by wyf on 2017/2/4.
 */

public interface HttpCallbackListener {

    void OnFinish(String response);
    void OnError(Exception e);
}
