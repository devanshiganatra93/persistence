package com.example.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="wType", discriminatorType = DiscriminatorType.STRING)
public class Widget {

    @Id
    protected Long id;
    protected String type;
    protected Integer height;
    protected Integer width;

    @ManyToOne()
    @JsonIgnore
    private Topic topic;

    public Widget () {}

/*
    public Widget(Long id, Integer height, Integer width, Topic topic) {

        this.id = id;
        this.height = height;
        this.width = width;
        this.topic = topic;
    }*/


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


    public void setWidget(Widget widget) {
        this.id = topic.getId();
        this.type = widget.getType();
        this.height = widget.getHeight();
        this.width = widget.getWidth();
    }

//    public void setHeadingWidget(Widget widget) {
//
//    }
}
