//Adapted from Udacity customAdapter
//Copyright (C) 2016 THE Android Open Source Project
//Licensed under the Apache License, Version 2.0 (the "License);

package com.example.android.songplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

//Shows a list of songs
//Song title, artist, and icon
public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        String song = getIntent().getStringExtra("song");
        String artist = getIntent().getStringExtra("artist");
        int img_resid = getIntent().getIntExtra("img_resid", 0);

        ((TextView)findViewById(R.id.song_now_playing)).setText(song);
        ((TextView)findViewById(R.id.artist_now_playing)).setText(artist);
        ((ImageView)findViewById(R.id.img_now_playing)).setImageResource(img_resid);
    }
}