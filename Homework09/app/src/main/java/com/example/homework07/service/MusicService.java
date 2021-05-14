package com.example.homework07.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    private MusicHelper musicHelper = null;

    @Override
    public void onCreate() {
        Log.d("MusicService------", "onCreate");
        super.onCreate();
        musicHelper = new MusicHelper(this);
    }
    @Override
    public void onDestroy() {
        Log.d("MusicService------", "onDestroy");
        super.onDestroy();
        musicHelper.destroy();
        musicHelper = null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        musicHelper.play();
        Log.d("MusicService------", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}