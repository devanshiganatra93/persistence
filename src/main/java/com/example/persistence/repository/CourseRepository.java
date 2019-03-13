package com.example.persistence.repository;

import com.example.persistence.model.*;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
