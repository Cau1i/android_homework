package com.example.homework07.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework07.R;

import java.util.Random;

public class ServicePlayMusicFragment2 extends Fragment {
    private MyConn myConn;

    public ServicePlayMusicFragment2() {
        super(R.layout.music_service_fagment2);
    }

    public class MyConn implements ServiceConnection {
        public MusicService2.MyBinder myBinder = null;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MusicService2.MyBinder) service;
            Log.d("MusicService2------", "绑定成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Intent intent = new Intent(getActivity(), MusicService2.class);
        getActivity().startService(intent);

        //bindService
        if (myConn == null) {
            myConn = new MyConn();
            intent = new Intent(getActivity(), MusicService2.class);
            getActivity().bindService(intent, myConn, 0);
        }


        //播放按钮
        Button btn_play = getView().findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myConn.myBinder == null) {
                    return;
                }
                myConn.myBinder.play();
                Log.d("MusicService2------", "play");
            }
        });

        //下一首按钮
        Button btn_next = getView().findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myConn.myBinder == null) {
                    return;
                }
                myConn.myBinder.next();
            }
        });

        //暂停按钮
        Button btn_pause = getView().findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myConn.myBinder == null) {
                    return;
                }
                myConn.myBinder.pause();
            }
        });
    }
}


