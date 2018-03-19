package com.javabrains.restservice.musician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class MusicianController {

    @Autowired
    MusicianService musicianService;

    @GetMapping("get-all-musicians")
    public List<Musician> doGet() {
        return musicianService.getAllMusicians();
    }

//    @GetMapping("/get-all-musicians")
//    public List<Musician> doGet() {
//        return musicianService.getAllMusicians();
//    }

    @GetMapping("/musician/{id}")
    public Musician getMusician (@PathVariable Long id) {
        return musicianService.getMusician(id);
    }

    @GetMapping("/add-musician")
    public String addMusicianIndex(Model model) {
        model.addAttribute("musicianForm", new MusicianForm());
        return "musicianForm";
    }


    @PostMapping("/add-musician")
    public String addMusician(Model model) {
        model.addAttribute("musicianForm", new MusicianForm());
//        Musician musician = new Musician(null, "${musicianForm.musicianFirstName}", "${musicianForm.musicianLastName}, )
//        musicianService.addMusician(musician);
        Musician musician = new Musician();
        musician.setId(55);
        musician.setMusicianFirstName("$musicianForm.musicianFirstName");
        musician.setMusicianFirstName("$musicianForm.musicianLastName");
        System.out.println(musician);
//        musicianService.addMusician(musician);
        return "musician";
    }

    @DeleteMapping("/delete-musician/{id}")
    public void deleteMusician(@PathVariable Long id) {
        musicianService.deleteMusician(id);
    }

}
