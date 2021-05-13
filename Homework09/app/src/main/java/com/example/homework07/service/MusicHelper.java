package com.example.homework07.service;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.homework07.R;

public class MusicHelper {
    private MediaPlayer mediaPlayer;
    private Context context;
    private final int[] musics = new int[]{R.raw.only, R.raw.options};
    private int musicIndex = 0;
    private boolean prepared = false;
    AssetManager am;

    public MusicHelper(Context context) {
        this.context = context;
        createMediaPlayer();
    }

    //创建MediaPlayer对象
    private void createMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    //播放音频
    public void play() {
        try {
            mediaPlayer.setDataSource(context,
                    Uri.parse("android.resource://com.example.homework07/" + musics[musicIndex]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mediaPlayer.prepareAsync();//TODO prepare过程中不允许操作按钮
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                prepared = true;
            }
        });

        if (mediaPlayer.isPlaying()) {
            return;
        }

        if (prepared) {
            mediaPlayer.start();
            return;
        }
    }

    //暂停
    public void pause() {
        if (!mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.pause();
    }

    //下一首
    public void next() {
        musicIndex = musicIndex + 1;
        musicIndex = musicIndex % musics.length;
        destroy();
        createMediaPlayer();
        play();
    }

    //销毁
    public void destroy() {
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
        prepared = false;
    }
}
