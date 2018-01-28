package com.javabrains.restservice.Artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController2 {

    @Autowired
    ArtistService artistService;

    @GetMapping("/artists")
    public List<Artist> getArtists() {
        return artistService.getAllArtists();
    }


}
