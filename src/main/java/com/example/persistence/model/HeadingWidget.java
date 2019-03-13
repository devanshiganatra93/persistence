package com.example.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HEADING_WIDGET")
public class HeadingWidget extends Widget{
    @Column(name = "size", nullable = false)
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
