package com.javabrains.restservice.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface TopicRepository extends JpaRepository<Topic, String> {


}
