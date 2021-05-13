package com.example.homework07.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework07.R;

public class ServicePlayMusicFragment extends Fragment {
    public ServicePlayMusicFragment() {
        super(R.layout.music_service_fragment);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //播放
        Button btn_pm = getView().findViewById(R.id.btn_pm);
        btn_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MusicService.class);
                getActivity().startService(intent);
            }
        });

        //停止
        Button btn_sm =getView().findViewById(R.id.btn_sm);
        btn_sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MusicService.class);
                getActivity().stopService(intent);
            }
        });
    }
}
