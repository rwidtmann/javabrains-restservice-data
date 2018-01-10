package com.javabrains.restservice.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public List<People> getAllPeople() {
        return personService.getAllPeople();
    }

    @PostMapping
    public void addPerson(@RequestBody People people) {
        personService.addPerson(people);
    }
}
