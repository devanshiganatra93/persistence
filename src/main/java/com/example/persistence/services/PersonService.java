package com.example.persistence.services;


import com.example.persistence.model.*;
import com.example.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    //Topic topic0 = new Topic();
/*
    Widget widget1 = new Widget(111111L,11, 12, null );

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

    Module module1 = new Module(111111L, "Module1", lessons);

    List<Module> modules = new ArrayList<Module>(){{
        add(module1);
    }};

    Course course1 = new Course (111111L, "Course1", modules);

    List<Course> courses = new ArrayList<Course>() {{
        add(course1);
    }};

    Person person1 = new Person ("usrName", "pwd", "d", "g", "email", 9909503664L, courses);

    List<Person> persons = new ArrayList<Person>() {{
        add(person1);
    }};*/

    @PostMapping("/api/register")
    public Person register(@RequestBody Person person,
                           HttpSession session) {
        session.setAttribute("currentUser", person);
        return personRepository.save(person);
    }

    @GetMapping("/api/profile")
    public Person profile(@RequestBody Person person, HttpSession session) {
        Person currentUser = (Person)
                session.getAttribute("currentUser");
        return personRepository.save(person);
    }

    @PostMapping("/api/login")
    public Person login(@RequestBody Person person,
                        HttpSession session) {

        Person prsn = personRepository.findUserByCredentials(person.getUserName(), person.getPassword());
                session.setAttribute("currentUser", prsn);
        return prsn;
    }

    @PostMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/api/users")
    public Person createPerson (@RequestBody Person person){

        return personRepository.save(person);
    }

    @PutMapping("/api/users/{userId}")
    public Person updatePerson(
            @PathVariable("userId") Long id,
            @RequestBody Person newPerson) {
        Person person = personRepository.findById(id).get();
        person.set(newPerson);
        return personRepository.save(person);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser
            (@PathVariable("userId") Long id) {
        personRepository.deleteById(id);
    }

    @GetMapping("/api/persons")
    public List<Person> findAllPersons() {

        return (List<Person>) personRepository.findAll();
    }

/*    @GetMapping("/api/persons/{pid}")
    public Person findPersonById(@PathVariable("pid") Long id) {
        for (Person person : persons) {
            if (id == person.getId().longValue())
                return person;
        }
        return null;
    }*/

    @GetMapping("/api/persons/{pid}")
    public Person findPersonById(@PathVariable("pid") Long id) {
        return personRepository.findById(id).get();
    }



}
