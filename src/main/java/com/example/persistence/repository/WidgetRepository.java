package com.example.persistence.repository;

import com.example.persistence.model.Topic;
import com.example.persistence.model.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Long> {
/*
    @Query
            ("SELECT widget FROM Widget widget WHERE widget.id=:id")
    public List<Widget> findWidgetById(@Param("id") Long id);*/
}
