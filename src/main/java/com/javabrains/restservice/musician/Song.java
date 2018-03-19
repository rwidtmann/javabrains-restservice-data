package com.javabrains.restservice.musician;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Song {

    private long id;
    private String songTitle;
    private String artistLastName;
    private String yearPublished;
    @JsonIgnore
    private Musician musician;

    public Song() {
    }

    public Song(long id, String songTitle, String artistLastName, String yearPublished, Musician musician) {
        this.id = id;
        this.songTitle = songTitle;
        this.artistLastName = artistLastName;
        this.yearPublished = yearPublished;
        this.musician = musician;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtistLastName() {
        return artistLastName;
    }

    public void setArtistLastName(String artistLastName) {
        this.artistLastName = artistLastName;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    @ManyToOne
    @JoinColumn(name = "musician_id")
    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songTitle='" + songTitle + '\'' +
                ", artistLastName='" + artistLastName + '\'' +
                ", yearPublished='" + yearPublished + '\'' +
                ", musician=" + musician +
                '}';
    }
}
