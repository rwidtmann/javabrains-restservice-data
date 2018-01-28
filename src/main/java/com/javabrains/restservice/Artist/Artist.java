package com.javabrains.restservice.Artist;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {

    private long id;
    private String artistFirstName;
    private String artistLastName;
    private List<Album> albumList;

    public Artist() {
    }

    public Artist(String artistFirstName, String artistLastName, List<Album> albumList) {
        this.artistFirstName = artistFirstName;
        this.artistLastName = artistLastName;
        this.albumList = albumList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtistFirstName() {
        return artistFirstName;
    }

    public void setArtistFirstName(String artistFirstName) {
        this.artistFirstName = artistFirstName;
    }

    public String getArtistLastName() {
        return artistLastName;
    }

    public void setArtistLastName(String artistLastName) {
        this.artistLastName = artistLastName;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
