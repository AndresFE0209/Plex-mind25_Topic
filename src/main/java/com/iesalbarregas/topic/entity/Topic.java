package com.iesalbarregas.topic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topic", nullable = false)
    private Long id;

    @Column(name = "name_topic", nullable = false, length = 50)
    private String nameTopic;

    @Column(name = "id_category", nullable = false)
    private Long idCategory;

}