package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    MediaPlayer m;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView pause=(ImageView)findViewById(R.id.pause);
        ImageView reset=(ImageView)findViewById(R.id.reset);
        ImageView play=(ImageView)findViewById(R.id.play);

        try {
            m=MediaPlayer.create(this,R.raw.music);
            m.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.pause();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.reset();
            }
        });
    }
}