package com.javabrains.restservice.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/people")
    public List<People> getAllPeople() {
        return personService.getAllPeople();
    }

    @PostMapping
    public void addPerson(@RequestBody People people) {
        personService.addPerson(people);
    }
}
