package com.example.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LIST_WIDGET")
public class ListWidget extends Widget{
    @Column(name = "items ordered", nullable = false)

    private String[] items;
    private Boolean ordered;

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }
}
