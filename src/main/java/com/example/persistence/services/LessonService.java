package com.example.persistence.services;

import com.example.persistence.model.Lesson;
import com.example.persistence.model.Module;
import com.example.persistence.model.Topic;
import com.example.persistence.model.Widget;
import com.example.persistence.repository.LessonRepository;
import com.example.persistence.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    ModuleRepository moduleRepository;

/*    Widget widget1 = new Widget(121L,11, 12, null );

    List<Widget> widgets = new ArrayList<Widget>(){{
        add(widget1);
    }};

    Topic topic1 = new Topic(111111L, "Topic1", widgets);

    List<Topic> topics = new ArrayList<Topic>(){{
        add(topic1);
    }};


    Lesson lesson1= new Lesson(111111L, "Lesson1", topics);

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        add(lesson1);
    }};*/

    @PostMapping("/api/module/{mid}/lesson")
    public Lesson createLesson(
            @PathVariable("mid") Long mid  , @RequestBody Lesson lesson) {
        lesson.setModule(moduleRepository.findById(mid).get());
        return lessonRepository.save(lesson);
    }

    @GetMapping("/api/module/{mid}/lesson")
    public List<Lesson> findAllLessons(
            @PathVariable("mid") Long mid) {

        //return (List<Lesson>) lessonRepository.findAll();
        return moduleRepository.findById(mid).get().getLessons();
    }

/*    @GetMapping("/api/lesson/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Long id) {
        for (Lesson lesson : lessons) {
            if (id == lesson.getId().longValue())
                return lesson;
        }
        return null;
    }*/

    @GetMapping("/api/lesson/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Long id) {
        return lessonRepository.findById(id).get();
    }

    @PutMapping("/api/lesson/{lid}")
    public Lesson updateLesson(@PathVariable("lid") Long id,@RequestBody Lesson lesson) {
        Lesson lsn = lessonRepository.findById(id).get();
        lsn.setLesson(lesson);
        return lessonRepository.save(lsn);
    }

    @DeleteMapping("/api/lesson/{lid}")
    public void deleteLesson(@PathVariable("lid") Long id) {
        lessonRepository.deleteById(id);

    }


}