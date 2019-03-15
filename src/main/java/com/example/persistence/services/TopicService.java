package com.example.persistence.services;

import com.example.persistence.model.Lesson;
import com.example.persistence.model.Topic;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.LessonRepository;
import com.example.persistence.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TopicService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    TopicRepository topicRepository;


    Widget widget1 = new Widget(121L, 11, 12, null );

    List<Widget> widgets = new ArrayList<Widget>(){{
        add(widget1);
    }};

    List<Topic> topics = new ArrayList<Topic>(){{
        add(topic1);
    }};

    Topic topic1= new Topic(111111L, "Topic1", widgets);

    @PostMapping("/api/lesson/{lid}/topic")
    public Topic createTopic(
            @PathVariable("lid") Long lid  , @RequestBody Topic topic) {
        topic.setLesson(lessonRepository.findById(lid).get());
        return topicRepository.save(topic);
    }


    @GetMapping("/api/lesson/{lid}/topic/")
    public List<Topic> findAllTopics(
            @PathVariable("lid") Long lid) {

        return (List<Topic>) topicRepository.findAll();
    }

    @GetMapping("/api/topic/{tid}")
    public Topic findTopicById(@PathVariable("tid") Long id) {
        for (Topic topic : topics) {
            if (id == topic.getId().longValue())
                return topic;
        }
        return null;
    }

    @PutMapping("/api/topic/{tid}")
    public Topic updateTopic(@PathVariable("tid") Long id, @RequestBody Topic topic) {
        Topic tpc = topicRepository.findById(id).get();
        tpc.setTopic(topic);
        return topicRepository.save(topic);

    }

    @DeleteMapping("/api/topic/{tid}")
    public void deleteTopic(@PathVariable("tid") Long id) {
        topicRepository.deleteById(id);

    }

}
