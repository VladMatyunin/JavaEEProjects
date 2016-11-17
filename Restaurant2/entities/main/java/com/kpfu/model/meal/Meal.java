package com.kpfu.model.meal;

import com.kpfu.model.ingredient.Ingredient;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Map;

/**
 * Created by Vlad.M on 12.11.2016.
 */
@Entity
public class Meal extends Product implements Cookable {
    public Meal(){
    }
    @EmbeddedId
    private Meal_Id id;
    public Meal(String name, String type){
        this.id = new Meal_Id(name,type);
        this.cost = 0.0f;
    }
    public Meal(String name, String type, Float cost){
        this(name,type);
        this.cost = cost;
    }
    public Meal(String name, String type, Float cost, String description){
        this(name,type,cost);
        this.description = description;
    }

    public Meal_Id getId() {
        return id;
    }

    public void setId(Meal_Id id) {
        this.id = id;
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

    public Map<Ingredient, Float> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Float> ingredients) {
        this.ingredients = ingredients;
    }
}
