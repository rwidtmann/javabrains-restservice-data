package com.javabrains.restservice.person;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<People, String> {

}
