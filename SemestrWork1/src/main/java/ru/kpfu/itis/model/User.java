package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Entity
@Table(name = "UserItem")
public class User {
    public User(){}
    public User(String name, String surname,String email,String password){
        this.name = name;
        this.surname = surname;
        this.rating = 0;
        this.email = email;
        this.password = password;
        this.userRole = "ROLE_USER";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "rating")
    private double rating;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "PostOwner")
    private List<Post> posts;
    @Column(name = "userrole", nullable = false)
    private String userRole;
    @Column(nullable = false, name = "password",length = 30)
    private String password;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
