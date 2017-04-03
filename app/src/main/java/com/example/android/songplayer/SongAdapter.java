//Adapted from Udacity customAdapter
//Copyright (C) 2016 THE Android Open Source Project
//Licensed under the Apache License, Version 2.0 (the "License);

package com.example.android.songplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class SongAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //check if existing view is being reused, otherwise inflate it
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song, parent, false);
        }

        Song currentSong = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.song_name);

        assert currentSong != null;
        nameTextView.setText(currentSong.getSongName());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        artistTextView.setText(currentSong.getSongArtist());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentSong.getImageResourceId());

        return listItemView;
    }
}