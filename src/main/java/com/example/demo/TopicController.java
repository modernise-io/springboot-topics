package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicsService topicsService;

    @RequestMapping("/")
    public int list(){
        logger.info("list");
        return 0;
    }

    @RequestMapping("/topics")
    public List<Topic> listTopics(){
        logger.info("listTopics");
        return topicsService.getAllTopicList();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic (@PathVariable("id") String id){
        logger.info("getTopic");
        return topicsService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        logger.info("addTopic");
        topicsService.addTopic(topic);
    }
}
