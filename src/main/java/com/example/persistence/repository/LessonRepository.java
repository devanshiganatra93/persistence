package com.example.persistence.repository;

import com.example.persistence.model.Lesson;
import com.example.persistence.model.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
/*
    @Query
            ("SELECT lesson FROM Lesson lesson WHERE lesson.id=:id")
    public List<Lesson> findLessonById(@Param("id") Long id);*/
}
