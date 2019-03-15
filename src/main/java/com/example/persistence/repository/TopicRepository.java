package com.example.persistence.repository;

import com.example.persistence.model.Module;
import com.example.persistence.model.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
/*
    @Query
            ("SELECT topic FROM Topic topic WHERE topic.id=:id")
    public List<Topic> findTopicById(@Param("id") Long id);*/
}

