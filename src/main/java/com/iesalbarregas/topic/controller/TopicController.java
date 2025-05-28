package com.iesalbarregas.topic.controller;

import com.iesalbarregas.topic.entity.Topic;
import com.iesalbarregas.topic.services.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Topic entities.
 * Provides endpoints for CRUD operations on topics.
 *
 * @author Andres Fernandez Exposito
 * @since 1.0
 */
@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicServices topicServices;

    /**
     * Constructor for TopicController.
     * Injects the TopicServices dependency.
     *
     * @param topicServices the service for topic operations
     */
    @Autowired
    public TopicController(TopicServices topicServices){
        this.topicServices= topicServices;
    }

    /**
     * Retrieves all topics.
     *
     * @return a list of all topics
     */
    @GetMapping
    public List<Topic> getAllTopics(){
        return topicServices.findALl();
    }


    /**
     * Retrieves all topics.
     *
     * @return a list of all topics
     */
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id){
        Optional<Topic> topic = topicServices.findById(id);
        return topic.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new topic.
     *
     * @param topic the topic to create
     * @return the created topic
     */
    @PostMapping
    public Topic createTopic(@RequestBody Topic topic){
        return topicServices.createTopic(topic);
    }

    /**
     * Updates an existing topic by its ID.
     *
     * @param id the ID of the topic to update
     * @param topic the topic data to update
     * @return ResponseEntity with the updated topic, or 404 if not found
     */
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

    /**
     * Deletes a topic by its ID.
     *
     * @param id the ID of the topic to delete
     */
    @DeleteMapping("/{id}")
    public void deletedById(@PathVariable Long id){
        topicServices.deletedTopic(id);
    }

}
