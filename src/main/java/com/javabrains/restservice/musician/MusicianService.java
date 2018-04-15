package com.javabrains.restservice.musician;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicianService {

    @Autowired
    private MusicianRepository musicianRepository;

    public List<Musician> getAllMusicians() {
        List<Musician> musicians = new ArrayList<>();
        musicianRepository.findAll().forEach(musicians::add);
        return musicians;
    }

    public Musician getMusician(Long id) {
       return musicianRepository.findOne(id);
    }

    public void addMusician(Musician musician) {
        musicianRepository.save(musician);
    }

    public void deleteMusician(Long id) {
        musicianRepository.delete(id);
    }
}
