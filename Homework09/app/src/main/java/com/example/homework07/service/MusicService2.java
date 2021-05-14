package com.example.homework07.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MusicService2 extends Service{
    private MusicHelper musicHelper = null;

    @Override
    public void onCreate() {
        Log.d("MusicService2------", "onCreate");
        // The service is being created
        super.onCreate();
        musicHelper = new MusicHelper(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // All clients have unbound with unbindService()
        Log.d("MusicService2------", "onUnbind");
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
        Log.d("MusicService2------", "onRebind");
    }

    @Override
    public void onDestroy() {
        // The service is no longer used and is being destroyed
        Log.d("MusicService2------", "onRebind");
        super.onDestroy();
    }

    public class MyBinder extends Binder {
        private MusicService2 service;

        public MyBinder(MusicService2 service) {
            this.service = service;
        }

        public void play() {
            service.musicHelper.play();
        }

        public void next() {
            service.musicHelper.next();
        }

        public void pause() {
            service.musicHelper.pause();
        }

        public void destroy() {
            service.musicHelper.destroy();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MusicService2------", "绑定服务，调用onBind");
        return new MyBinder(this);
    }
}
