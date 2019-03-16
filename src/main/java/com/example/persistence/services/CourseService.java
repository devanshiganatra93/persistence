package com.example.persistence.services;

import com.example.persistence.model.*;
import com.example.persistence.repository.CourseRepository;
import org.omg.CORBA.PERSIST_STORE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
/*
    Widget widget1 = new Widget(111111L, 11, 12, null );

    List<Widget> widgets = new ArrayList<Widget>(){{
        add(widget1);
    }};

    Topic topic1 = new Topic(111111L, "Topic1", widgets);

    List<Topic> topics = new ArrayList<Topic>(){{
        add(topic1);
    }};

    Lesson lesson1 = new Lesson(111111L, "Lesson1", topics);

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        add(lesson1);
    }};

    Module module1= new Module(111111L, "Module1", lessons);

    List<Module> modules = new ArrayList<Module>(){{
        add(module1);
    }};

    Course course1 = new Course(111111L, "Course1", modules);

    List<Course> courses = new ArrayList<Course>(){{
        add(course1);
    }};*/

    @PostMapping("/api/courses")
    public Course createCourse(
            @RequestBody Course course, HttpSession session) {
        //session.setAttribute("currentUser", Person);
        course.setAuthor((Person) session.getAttribute("currentUser"));
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {

        return (List<Course>) courseRepository.findAll();
    }

/*    @GetMapping("/api/courses/{cid}")
    public Course findCourseById(@PathVariable("cid") Long id) {
        for (Course course : courses) {
            if (id == course.getId().longValue())
                return course;
        }
        return null;
    }*/

    @GetMapping("/api/courses/{cid}")
    public Course findCourseById(@PathVariable("cid") Long id) {
        return courseRepository.findById(id).get();
    }

    @PutMapping("/api/courses/{cid}")
    public Course updateCourse(@PathVariable("cid") Long id, @RequestBody Course course) {
        Course crse = courseRepository.findById(id).get();
        crse.set(course);
        return courseRepository.save(crse);

    }

    @DeleteMapping("/api/courses/{cid}")
    public void deleteCourse(@PathVariable("cid") Long id) {
        courseRepository.deleteById(id);

    }

}
