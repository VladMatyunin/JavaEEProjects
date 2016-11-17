package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Entity
@Table(name = "posts")
public class Post {
    public Post(){}
    public Post(String name, String text, User user, List<Tag> tags, Date date){
        this.name = name;
        this.text = text;
        this.PostOwner = user;
        this.tags = tags;
        this.rating = 0;
        this.date = date;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false,unique = false)
    private String name;
    @Column(nullable = false, length = 6000)
    private String text;
    @Column(nullable = false)
    private Integer rating;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name = "U_ID", nullable = false)
    private User PostOwner;
    @Column(name = "postdate", nullable = false)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;
    public List<Tag> getTags() {
        return tags;
    }


    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPostOwner() {
        return PostOwner;
    }

    public void setPostOwner(User postOwner) {
        PostOwner = postOwner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public String getOwnerName(){
        return this.getPostOwner().getName();
    }
    public String getOwnerEmail(){
        return this.getPostOwner().getEmail();
    }
}
