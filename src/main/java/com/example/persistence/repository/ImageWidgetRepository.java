package com.example.persistence.repository;

import com.example.persistence.model.HeadingWidget;
import com.example.persistence.model.ImageWidget;
import com.example.persistence.model.Widget;
import org.springframework.data.repository.CrudRepository;

public interface ImageWidgetRepository extends CrudRepository<ImageWidget, Long> {


}