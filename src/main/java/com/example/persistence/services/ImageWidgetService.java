package com.example.persistence.services;

import com.example.persistence.model.HeadingWidget;
import com.example.persistence.model.ImageWidget;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.HeadingWidgetRepository;
import com.example.persistence.repository.ImageWidgetRepository;
import com.example.persistence.repository.TopicRepository;
import com.example.persistence.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageWidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    ImageWidgetRepository imageWidgetRepository;

    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/api/image/widget/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Long id) {
        return imageWidgetRepository.findById(id).get();
    }

    @DeleteMapping("/api/image/widget/{wid}")
    public void deleteWidget(@PathVariable("wid") Long id) {

        imageWidgetRepository.deleteById(id);
    }

    @PutMapping("/api/image/widget/{wid}")
    public ImageWidget updateWidget(@PathVariable("wid") Long id, @RequestBody ImageWidget widget) {
        System.out.println("inside");
        Widget wgt = widgetRepository.findById(id).get();
        widget.setTopic(wgt.getTopic());
        widgetRepository.deleteById(id);
        widget.setId(id);
        return imageWidgetRepository.save(widget);
    }
}
