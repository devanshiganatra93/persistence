package com.example.persistence.services;

import com.example.persistence.model.HeadingWidget;
import com.example.persistence.model.ImageWidget;
import com.example.persistence.model.ParagraphWidget;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ParagraphWidgetService {
    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    ParagraphWidgetRepository paragraphWidgetRepository;

    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/api/paragraph/widget/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Long id) {
        return paragraphWidgetRepository.findById(id).get();
    }

    @DeleteMapping("/api/paragraph/widget/{wid}")
    public void deleteWidget(@PathVariable("wid") Long id) {

        paragraphWidgetRepository.deleteById(id);
    }

    @PutMapping("/api/paragraph/widget/{wid}")
    public ParagraphWidget updateWidget(@PathVariable("wid") Long id, @RequestBody ParagraphWidget widget) {
        Widget wgt = widgetRepository.findById(id).get();
        widget.setTopic(wgt.getTopic());
        widgetRepository.deleteById(id);
        widget.setId(id);
        return paragraphWidgetRepository.save(widget);

    }
}
