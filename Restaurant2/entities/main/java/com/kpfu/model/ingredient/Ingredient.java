package com.kpfu.model.ingredient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Vlad.M on 12.11.2016.
 */
@Entity
public class Ingredient implements Serializable{
    public Ingredient(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1,max = 25)
    @Column(nullable = false, unique = true)
    private String name;
    @NotNull
    @Column(nullable = false)
    private Float cost;
    @NotNull
    @Column(nullable = false)
    private Float value;
    @NotNull
    @Column(nullable = false)
    private String metrics;
    private String description;
    public Long getId() {
        return id;
    }
    public Ingredient(String name, Float cost, Float value, String metrics){
        this.name = name;
        this.cost = cost;
        this.value = value;
        this.metrics = metrics;
    }
    public Ingredient(String name, Float cost, Float value, String metrics,String description){
        this(name,cost,value,metrics);
        this.description = description;
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
