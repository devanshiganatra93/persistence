package com.example.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PARAGRAPH_WIDGET")
public class ParagraphWidget extends Widget{
    @Column(name = "text")
    private String text;

/*    public ParagraphWidget(){}

    public ParagraphWidget(String text) {
        this.text = text;
    }

    public ParagraphWidget(Long id, Integer height, Integer width, Topic topic, String text) {
        super(id, height, width, topic);
        this.text = text;
    }*/

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
