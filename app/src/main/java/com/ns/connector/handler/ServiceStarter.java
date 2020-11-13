package com.ns.connector.handler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import com.ns.connector.services.ConnectorService;

public class ServiceStarter extends BroadcastReceiver {
    boolean startup = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        startup = prefs.getBoolean("startupSetting", true);
        if (startup) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(new Intent(context, ConnectorService.class));
            } else {
                context.startService(new Intent(context, ConnectorService.class));
            }
        }

    }
}