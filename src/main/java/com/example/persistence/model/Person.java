package com.example.persistence.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    //private Person person;



    @OneToMany(mappedBy="author")
    private List<Course> courses;

/*    public Person () {}

    public Person(String userName, String password, String firstName, String lastName, String email, Long phoneNumber, List<Course> courses) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courses = courses;
    }*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void set(Person newPerson) {
        this.userName = newPerson.getUserName();
        this.password = newPerson.getPassword();
        this.firstName = newPerson.getFirstName();
        this.lastName = newPerson.getLastName();
        this.email = newPerson.getEmail();
        this.phoneNumber = newPerson.getPhoneNumber();
        this.courses = newPerson.getCourses();
    }
}
