package com.javabrains.restservice.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @PostMapping("/add-person")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }
}
