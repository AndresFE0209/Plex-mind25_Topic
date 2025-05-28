package com.iesalbarregas.topic.repository;

import com.iesalbarregas.topic.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Service class for managing topics.
 * this class is responsible for business logic related to topics.
 * @author Andres Fernandez Exposito
 * since 1.0
 */
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
