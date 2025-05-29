package com.iesalbarregas.topic.services;

import com.iesalbarregas.topic.entity.Topic;
import com.iesalbarregas.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service class for managing topics.
 * this class is responsible for business logic related to topics.
 * @author Andres Fernandez Exposito
 * since 1.0
 */
@Service
public class TopicServices {
    private final TopicRepository topicRepository;

    /**
     * Constructor for TopicServices.
     * Injects the TopicRepository dependency.
     *
     * @param topicRepository the repository for Topic entities
     */
    @Autowired
    public TopicServices(TopicRepository topicRepository){
        this.topicRepository=topicRepository;
    }

    /**
     * Retrieves all topics from the database.
     *
     * @return a list of all topics
     */
    public List<Topic> findALl(){
        return topicRepository.findAll();
    }

    /**
     * Finds a topic by its ID.
     *
     * @param id the ID of the topic
     * @return an Optional containing the topic if found, or empty if not found
     */
    public Optional<Topic>findById(Long id){
        return topicRepository.findById(id);
    }

    /**
     * Creates or updates a topic in the database.
     *
     * @param topic the Topic entity to save
     * @return the saved topic
     */
    public Topic createTopic (Topic topic){
        return topicRepository.save(topic);
    }

    /**
     * Deletes a topic by its ID.
     *
     * @param id the ID of the topic to delete
     */
    public void deletedTopic(Long id){
        topicRepository.deleteById(id);
    }
}
