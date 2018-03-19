package com.javabrains.restservice.home;


import com.javabrains.restservice.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "home/index";
    }

    @GetMapping("/musician")
    public String index() {
        return "home/musicianIndex";
    }

}
