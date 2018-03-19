package com.javabrains.restservice.musician;

public class MusicianForm {
    private String musicianFirstName;
    private String musicianLastName;

    public MusicianForm() {
    }

    public MusicianForm(String musicianFirstName, String musicianLastName) {
        this.musicianFirstName = musicianFirstName;
        this.musicianLastName = musicianLastName;
    }

    public String getMusicianFirstName() {
        return musicianFirstName;
    }

    public void setMusicianFirstName(String musicianFirstName) {
        this.musicianFirstName = musicianFirstName;
    }

    public String getMusicianLastName() {
        return musicianLastName;
    }

    public void setMusicianLastName(String musicianLastName) {
        this.musicianLastName = musicianLastName;
    }

    @Override
    public String toString() {
        return "MusicianForm{" +
                "musicianFirstName='" + musicianFirstName + '\'' +
                ", musicianLastName='" + musicianLastName + '\'' +
                '}';
    }
}