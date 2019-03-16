package com.example.persistence.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("hWidget")
public class HeadingWidget extends Widget{
    @Column(name = "size")
    private Integer size;

/*    HeadingWidget() {}

    public HeadingWidget(int size) {
        this.size = size;
    }

    public HeadingWidget(Long id, Integer height, Integer width, Topic topic, int size) {
        super(id, height, width, topic);
        this.size = size;
    }*/


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
