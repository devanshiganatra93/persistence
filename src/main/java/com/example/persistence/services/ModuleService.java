package com.example.persistence.services;

import com.example.persistence.model.*;
import com.example.persistence.repository.CourseRepository;
import com.example.persistence.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    CourseRepository courseRepository;

/*    Widget widget1 = new Widget(12121L, 11, 12, null );

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
    }};*/

    @PostMapping("/api/courses/{cid}/modules")
    public Module createModule(
            @PathVariable("cid") Long cid  , @RequestBody Module module) {
        //modules.add(module);
        module.setCourse(courseRepository.findById(cid).get());
        return moduleRepository.save(module);
    }


    @GetMapping("api/course/{cid}/modules")
    public List<Module> findAllModules(
            @PathVariable("cid") Long cid) {

        return (List<Module>) moduleRepository.findAll();
    }

/*    @GetMapping("api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Long id) {
        for (Module module : modules) {
            if (id == module.getId().longValue())
                return module;
        }
        return null;
    }*/


    @GetMapping("api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Long id) {
            return moduleRepository.findById(id).get();
    }

    @PutMapping("/api/modules/{mid}")
    public Module updateModule(@PathVariable("mid") Long id, @RequestBody Module module) {
        Module mdle = moduleRepository.findById(id).get();
        mdle.setModule(module);
        return moduleRepository.save(module);

    }

    @DeleteMapping("/api/modules/{mid}")
    public void deleteModule(@PathVariable("mid") Long id) {
        moduleRepository.deleteById(id);

    }



}