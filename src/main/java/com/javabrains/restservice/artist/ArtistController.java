package com.javabrains.restservice.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/all-artists")
    public List<Artist> getArtists() {
        return artistService.getAllArtists();
    }


}
