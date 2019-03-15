package com.example.persistence.repository;

import com.example.persistence.model.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Long> {

/*    @Query
            ("SELECT module FROM Module module WHERE module.id=:id")
    public List<Module> findModuleById(@Param("id") Long id);*/

}
