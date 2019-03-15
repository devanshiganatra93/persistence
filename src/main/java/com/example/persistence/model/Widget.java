package com.example.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Widget {

    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)


    private Long id;
    private String type;
    private Integer height;
    private Integer width;

    @ManyToOne()
    @JsonIgnore
    private Topic topic;

    public Widget () {}


    public Widget(Long id, Integer height, Integer width, Topic topic) {

        this.id = id;
        this.height = height;
        this.width = width;
        this.topic = topic;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


}
