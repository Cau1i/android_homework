package com.example.homework07.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework07.R;

public class ServicePlayMusicFragment2 extends Fragment {
    MyConn myConn;

    public ServicePlayMusicFragment2() {
        super(R.layout.music_service_fagment2);
    }

    public class MyConn implements ServiceConnection {
        public MusicService2.MyBinder myBinder = null;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MusicService2.MyBinder) service;
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

        if (myConn == null) {
            myConn = new MyConn();
            intent = new Intent(getActivity(), MusicService2.class);
            getActivity().bindService(intent, myConn, 0);
        }
        //播放
        Button btn_play = getView().findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "0", Toast.LENGTH_SHORT).show();
                if (myConn.myBinder == null) {
                    return;
                }
                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                myConn.myBinder.play();
                Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
            }
        });

        //暂停
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


