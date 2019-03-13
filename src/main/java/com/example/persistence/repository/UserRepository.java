package com.example.persistence.repository;

import com.example.persistence.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<Person, Long> {

    @Query
    ("SELECT user FROM User user WHERE user.username=:username")

            public List<Person> findUserByUsername(@Param("username") String username);

    @Query
    ("SELECT user from User user WHERE user.username=:username AND user.password=:password")
            public List<Person> findUserByCredentials(@Param("username") String username, @Param("password") String password);

}
