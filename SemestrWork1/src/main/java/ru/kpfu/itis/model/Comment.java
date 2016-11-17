package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vlad.M on 07.09.2016.
 */

@Entity
public class Comment {
    public Comment(){}
    public Comment(String text, User user){
        this.text = text;
        this.user = user;
        this.date = new Date();
    }
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text", nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getUserName(){
        return user.getName();
    }
}
