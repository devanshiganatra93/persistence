package com.example.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {

    @Id
    private Long id;
    private String title;

    @OneToMany(mappedBy="topic")
    private List<Widget> widgets;

    @ManyToOne()
    @JsonIgnore
    private Lesson lesson;

/*    public Topic () {}

    public Topic(Long id, String title, List<Widget> widgets) {
        this.id = id;
        this.title = title;
        this.widgets = widgets;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setTopic (Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.widgets = topic.getWidgets();
    }
}
