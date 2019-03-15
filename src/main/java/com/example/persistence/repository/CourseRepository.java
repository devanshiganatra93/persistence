package com.example.persistence.repository;

import com.example.persistence.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {


    @Query
            ("SELECT course FROM Course course WHERE course.title=:title")
    public List<Course> findCourseByTitle(@Param("title") String title);

/*    @Query
            ("SELECT course from Course course WHERE course.title=:title AND course.id=:id")
    public List<Course> findCourseById(@Param("title") String title, @Param("id") Long id);*/


}
