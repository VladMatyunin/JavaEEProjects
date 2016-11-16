package com.kpfu.model.users;

import com.kpfu.model.orders.Order;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Vlad.M on 12.11.2016.
 */
@Table(name = "MY_USER")
@Entity
public class User implements Serializable{
    public User(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 2,max = 25, message = "wrong name")
    @Column(name = "USR_NAME", nullable = false)
    private String name;
    @Size(min = 5,max = 25, message = "wrong email")
    @Email
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orderList;
    @NotNull
    @Size(min = 5,max = 25, message = "wrong password. Should be between")
    @Column(name = "USR_PASSWD", nullable = false)
    private String password;

    public User(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "  Email:" + this.email;
    }
}
