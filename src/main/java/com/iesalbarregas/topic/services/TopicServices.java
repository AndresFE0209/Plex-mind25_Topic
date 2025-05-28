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
     */
    @Autowired
    public TopicServices(TopicRepository topicRepository){
        this.topicRepository=topicRepository;
    }

    public List<Topic> findALl(){
        return topicRepository.findAll();
    }

    public Optional<Topic>findById(Long id){
        return topicRepository.findById(id);
    }

    public Topic createTopic (Topic topic){
        return topicRepository.save(topic);
    }

    public void deletedTopic(Long id){
        topicRepository.deleteById(id);
    }


}
