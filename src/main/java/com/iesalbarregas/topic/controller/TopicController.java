package com.iesalbarregas.topic.controller;

import com.iesalbarregas.topic.entity.Topic;
import com.iesalbarregas.topic.services.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicServices topicServices;

    @Autowired
    public TopicController(TopicServices topicServices){
        this.topicServices= topicServices;
    }

    @GetMapping
    public List<Topic> getAllTopics(){
        return topicServices.findALl();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id){
        Optional<Topic> topic = topicServices.findById(id);
        return topic.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic){
        return topicServices.createTopic(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topic){
        Optional<Topic> existingTopic = topicServices.findById(id);
        if(existingTopic.isPresent()){
            Topic updated = existingTopic.get();
            updated.setNameTopic(topic.getNameTopic());
            updated.setIdCategory(topic.getIdCategory());
            return ResponseEntity.ok(topicServices.createTopic(updated));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deletedById(Long id){
        topicServices.deletedTopic(id);
    }

}
