//Adapted from Udacity customAdapter
//Copyright (C) 2016 THE Android Open Source Project
//Licensed under the Apache License, Version 2.0 (the "License);

package com.example.android.songplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

//Shows a list of songs
//Song title, artist, and icon
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Get Up Offa That Thing", "James Brown", R.drawable.james_brown));
        songs.add(new Song("Cold Sweat", "James Brown", R.drawable.james_brown));
        songs.add(new Song("The Payback", "James Brown", R.drawable.james_brown));
        songs.add(new Song("Because We Believe", "Andrea Bocelli", R.drawable.andrea_bocelli));
        songs.add(new Song("Time to Say Goodbye", "Andrea Bocelli", R.drawable.andrea_bocelli));
        songs.add(new Song("Vivo Per Lei", "Andrea Bocelli", R.drawable.andrea_bocelli));
        songs.add(new Song("The Prayer", "Andrea Bocelli", R.drawable.andrea_bocelli));
        songs.add(new Song("Abi Gezunt", "The Barry Sisters", R.drawable.barry_sisters));
        songs.add(new Song("Chibirim", "The Barry Sisters", R.drawable.barry_sisters));
        songs.add(new Song("Ay Ay Hora", "The Barry Sisters", R.drawable.barry_sisters));

        SongAdapter songAdapter = new SongAdapter(this, songs);

        final ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(songAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song clickedSong = (Song) listView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), NowPlayingActivity.class);
                intent.putExtra("song", clickedSong.getSongName());
                intent.putExtra("artist", clickedSong.getSongArtist());
                intent.putExtra("img_resid", clickedSong.getImageResourceId());
                startActivity(intent);
            }
        });

        //click listener fo button in listview to switch to grid view
        Button gridButton = (Button)findViewById(R.id.grid_view_switch_button);
        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), GridActivity.class);
                intent.putParcelableArrayListExtra("songs", songs);
                startActivity(intent);
            }
        });
    }
}