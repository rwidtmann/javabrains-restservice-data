package com.javabrains.restservice.musician;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Musician {

    private Long id;
    private String musicianFirstName;
    private String musicianLastName;
    private List<Song> songList;

    public Musician() {
    }

    public Musician(long id, String musicianFirstName, String musicianLastName, List<Song> songList) {
        this.id = id;
        this.musicianFirstName = musicianFirstName;
        this.musicianLastName = musicianLastName;
        this.songList = songList;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @OneToMany(mappedBy = "musician", cascade = CascadeType.ALL)
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

}
