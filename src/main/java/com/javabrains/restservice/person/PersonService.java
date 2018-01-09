package com.javabrains.restservice.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<People> getAllPeople() {
        List<People> peopleList = new ArrayList<>();
        personRepository.findAll().forEach(peopleList::add);
        return peopleList;
    }

    public void addPerson(People people) {
        personRepository.save(people);
    }
}
