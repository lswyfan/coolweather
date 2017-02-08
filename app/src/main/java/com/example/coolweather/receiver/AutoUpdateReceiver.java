package com.example.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.coolweather.service.AutoUpdateService;

/**
 * Created by wyf on 2017/2/8.
 */

public class AutoUpdateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       // Toast.makeText(context,"ok",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);
    }
}
