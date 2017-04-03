//Adapted from Udacity customAdapter
//Copyright (C) 2016 THE Android Open Source Project
//Licensed under the Apache License, Version 2.0 (the "License);

package com.example.android.songplayer;

import android.os.Parcel;
import android.os.Parcelable;

class Song implements Parcelable {

    private String songName;
    private String songArtist;
    private int imageResourceId;

    Song(String songName, String songArtist, int imageResourceId) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.imageResourceId = imageResourceId;
    }

    String getSongName() {
        return songName;
    }

    String getSongArtist() {
        return songArtist;
    }

    int getImageResourceId() {
        return imageResourceId;
    }

    //Implementing parcelable to allow passing ArrayList<Song>
    //followed example from Miro Markaravanes -
    //http://stackoverflow.com/questions/22446359/android-class-parcelable-with-arraylist
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(songArtist);
        dest.writeInt(imageResourceId);
    }

    private Song(Parcel parcel) {
        this.songName = parcel.readString();
        this.songArtist = parcel.readString();
        this.imageResourceId = parcel.readInt();
    }

    // Method to recreate a Question from a Parcel
    public static Creator<Song> CREATOR = new Creator<Song>() {

        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}