package com.example.persistence.services;

import com.example.persistence.model.Topic;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.LessonRepository;
import com.example.persistence.repository.TopicRepository;
import com.example.persistence.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class WidgetService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;



    @PostMapping("/api/topic/{tid}/widget")
    public Widget createWidget(
            @PathVariable("tid") Long tid  , @RequestBody Widget widget) {
        System.out.println("inside");
        widget.setTopic(topicRepository.findById(tid).get());
        return widgetRepository.save(widget);
    }



    @GetMapping("/api/topic/{tid}/widget")
    public List<Widget> findAllWidgets(
            @PathVariable("tid") Long tid) {
        //return (List<Widget>) widgetRepository.findAll();
        return topicRepository.findById(tid).get().getWidgets();
    }



    @GetMapping("/api/widget/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Long id) {
        return widgetRepository.findById(id).get();
    }

    @PutMapping("/api/widget/{wid}")
    public Widget updateWidget(@PathVariable("wid") Long id, @RequestBody Widget widget) {
        Widget wgt = widgetRepository.findById(id).get();
        wgt.setWidget(widget);
        return widgetRepository.save(wgt);

    }

    @DeleteMapping("/api/widget/{wid}")
    public void deleteWidget(@PathVariable("wid") Long id) {
        widgetRepository.deleteById(id);
    }
}


