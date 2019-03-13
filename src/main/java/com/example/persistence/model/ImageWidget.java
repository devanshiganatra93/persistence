package com.example.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGE_WIDGET")
public class ImageWidget extends Widget{

    @Column(name = "source", nullable = false)
    private  String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
