package com.example.persistence.repository;

import com.example.persistence.model.ListWidget;
import com.example.persistence.model.Widget;
import org.springframework.data.repository.CrudRepository;

public interface ListWidgetRepository extends CrudRepository<ListWidget, Long> {
}
