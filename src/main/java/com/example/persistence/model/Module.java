package com.example.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {

    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @OneToMany(mappedBy="module")
    private List<Lesson> lessons;

    @ManyToOne()
    @JsonIgnore
    private Course course;

    public Module () {}

    public Module(Long id, String title, List<Lesson> lessons) {
        this.id = id;
        this.title = title;
        this.lessons = lessons;
    }

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}