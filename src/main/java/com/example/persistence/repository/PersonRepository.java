package com.example.persistence.repository;

import com.example.persistence.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query
    ("SELECT person FROM Person person WHERE person.userName=:username")
            public List<Person> findUserByUsername(@Param("username") String username);
    @Query
    ("SELECT person from Person person WHERE person.userName=:username AND person.password=:password")
            public Person findUserByCredentials(@Param("username") String username, @Param("password") String password);

}
