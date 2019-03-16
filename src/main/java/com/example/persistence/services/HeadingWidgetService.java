package com.example.persistence.services;


import com.example.persistence.model.HeadingWidget;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.HeadingWidgetRepository;
import com.example.persistence.repository.TopicRepository;
import com.example.persistence.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HeadingWidgetService {


    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    HeadingWidgetRepository headingWidgetRepository;

    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/api/heading/widget/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Long id) {
        return headingWidgetRepository.findById(id).get();
    }

    @DeleteMapping("/api/heading/widget/{wid}")
    public void deleteWidget(@PathVariable("wid") Long id) {

        headingWidgetRepository.deleteById(id);
    }

    @PutMapping("/api/heading/widget/{wid}")
    public HeadingWidget updateWidget(@PathVariable("wid") Long id, @RequestBody HeadingWidget widget) {
        Widget wgt = widgetRepository.findById(id).get();
        widget.setTopic(wgt.getTopic());
        widgetRepository.deleteById(id);
        widget.setId(id);
        return headingWidgetRepository.save(widget);

    }

}

