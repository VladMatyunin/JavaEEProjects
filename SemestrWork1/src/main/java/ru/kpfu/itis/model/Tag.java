package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Entity
@Table(name = "tags")
public class Tag {
    public Tag(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",nullable = false,unique = true, length = 20)
    private String name;

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
}
