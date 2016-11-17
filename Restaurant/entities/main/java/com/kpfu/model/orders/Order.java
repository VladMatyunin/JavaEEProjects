package com.kpfu.model.orders;

import com.kpfu.myconstraints.annotations.CorrectDate;
import com.kpfu.myconstraints.annotations.Future;
import com.kpfu.model.meal.Drink;
import com.kpfu.model.users.User;
import com.kpfu.model.meal.Meal;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Vlad.M on 12.11.2016.
 */
@Table(name = "MY_ORDERS")
@Entity
@CorrectDate
@Future
public class Order {
    public Order(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,name = "meal_fk")
    private List<Meal> mealList;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,name = "drink_fk")
    private List<Drink> drinkList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ORDER",joinColumns = @JoinColumn(name = "USER_FK"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_FK"))
    private User user;
    private Date date;
    private Date delivery_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }
}
