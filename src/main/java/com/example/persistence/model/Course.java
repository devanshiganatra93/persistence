package com.example.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@Entity
public class Course {

    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne()
    @JsonIgnore
    private Person author;

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author){
        this.author = author;
    }

    //private List<Module> modules;

    public Course(Long id, String title){
        this.id = id;
        this.title = title;
        //this.modules = modules;
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

/*    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }*/


}
