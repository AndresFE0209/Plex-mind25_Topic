package com.iesalbarregas.topic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing a Topic.
 * Maps to the "topic" table in the database.
 * Contains information about a topic, including its name and category.
 *
 * @author Andres Fernandez Exposito
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "topic")
public class Topic {

    /**
     * Unique identifier for the topic.
     * Maps to the "id_topic" column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topic", nullable = false)
    private Long id;

    /**
     * Name of the topic.
     * Maps to the "name_topic" column.
     */
    @Column(name = "name_topic", nullable = false, length = 50)
    private String nameTopic;

    /**
     * Identifier of the category to which the topic belongs.
     * Maps to the "id_category" column.
     */
    @Column(name = "id_category", nullable = false)
    private Long idCategory;

}