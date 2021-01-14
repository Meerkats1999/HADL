package com.example.mpappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play, pause, stop, forward, rewind;
    MediaPlayer mplayer;
    int startime = 0;
    int endtime = 0;
    int ftime = 5000;
    int btime = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        forward = findViewById(R.id.forward);
        rewind = findViewById(R.id.rewind);
        mplayer = MediaPlayer.create(this, R.raw.song);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Playing", Toast.LENGTH_SHORT).show();
                mplayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Media is paused", Toast.LENGTH_SHORT).show();
                mplayer.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Media is stopped", Toast.LENGTH_SHORT).show();
                mplayer.stop();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentposition = mplayer.getCurrentPosition();
                int overalltime = mplayer.getDuration();
                if (currentposition + ftime < overalltime)
                    mplayer.seekTo(currentposition + ftime);
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentposition = mplayer.getCurrentPosition();
                int overalltime = mplayer.getDuration();
                if (currentposition - btime != overalltime)
                    mplayer.seekTo(currentposition - btime);
            }
        });
    }
}