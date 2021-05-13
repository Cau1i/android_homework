package com.example.homework07.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService2 extends Service {
    private MusicHelper musicHelper = null;

    MusicService2(){
        super.onDestroy();
    }

    public class MyBinder extends Binder{
        private MusicService2 service;
        public MyBinder(MusicService2 service){
            this.service =service;
        }
        public void play(){service.musicHelper.play();}

        public void next(){service.musicHelper.next();}

        public void pause(){service.musicHelper.pause();}

        public void destroy(){service.musicHelper.destroy();}
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MusicService------","onBind");
        return new MyBinder(this);
    }
}
