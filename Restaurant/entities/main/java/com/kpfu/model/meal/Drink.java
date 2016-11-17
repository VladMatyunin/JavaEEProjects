package com.kpfu.model.meal;

import com.kpfu.model.ingredient.Ingredient;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Vlad.M on 12.11.2016.
 */
@Entity
public class Drink extends Product implements Cookable {
    public Drink(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;


    public Drink(String name, Float cost){
        this.name = name;
        this.cost = cost;
    }
    public Drink(String name){
        this.name = name;
        this.cost = new Float(0.0f);
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

    public Map<Ingredient, Float> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Float> ingredients) {
        this.ingredients = ingredients;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
