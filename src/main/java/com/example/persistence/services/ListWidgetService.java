package com.example.persistence.services;

import com.example.persistence.model.HeadingWidget;
import com.example.persistence.model.ImageWidget;
import com.example.persistence.model.ListWidget;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.HeadingWidgetRepository;
import com.example.persistence.repository.ListWidgetRepository;
import com.example.persistence.repository.TopicRepository;
import com.example.persistence.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class ListWidgetService {



    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    ListWidgetRepository listWidgetRepository;

    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/api/list/widget/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Long id) {
        return listWidgetRepository.findById(id).get();
    }

    @DeleteMapping("/api/list/widget/{wid}")
    public void deleteWidget(@PathVariable("wid") Long id) {

        listWidgetRepository.deleteById(id);
    }

    @PutMapping("/api/list/widget/{wid}")
    public ListWidget updateWidget(@PathVariable("wid") Long id, @RequestBody ListWidget widget) {
        Widget wgt = widgetRepository.findById(id).get();
        widget.setTopic(wgt.getTopic());
        widgetRepository.deleteById(id);
        widget.setId(id);
        return listWidgetRepository.save(widget);

    }
}
