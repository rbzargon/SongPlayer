package com.example.android.songplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        //Retrieve songs from parceled ArrayList
        Intent intent = getIntent();
        ArrayList<Song> songs =  intent.getParcelableArrayListExtra("songs");

        SongAdapter songAdapter = new SongAdapter(this, songs);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(songAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song clickedSong = (Song) gridView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), NowPlayingActivity.class);
                intent.putExtra("song", clickedSong.getSongName());
                intent.putExtra("artist", clickedSong.getSongArtist());
                intent.putExtra("img_resid", clickedSong.getImageResourceId());
                startActivity(intent);
            }
        });

        //click listener for button in gridview to switch to list view
        Button gridButton = (Button)findViewById(R.id.list_view_switch_button);
        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
            }
        });

    }
}