package com.javabrains.restservice.artist;


import javax.persistence.*;

@Entity
public class Album {

    private long id;
    private String albumName;
    private String releaseYear;
    private Artist artist;


    public Album() {
    }

    public Album(int id, String albumName, String releaseYear, Artist artist) {
        this.id = id;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.artist = artist;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }


}
