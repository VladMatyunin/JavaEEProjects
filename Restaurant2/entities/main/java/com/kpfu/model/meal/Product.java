package com.kpfu.model.meal;

import com.kpfu.model.ingredient.Ingredient;
import com.kpfu.myconstraints.annotations.IngredientPrice;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vlad.M on 13.11.2016.
 */
@MappedSuperclass
public abstract class Product {
    @ElementCollection
    @CollectionTable(name="Drinks_Ingedients")
    @MapKeyColumn(name="Ingredient_id")
    @Column(name="Ingredient_Value")
    @IngredientPrice
    protected Map<Ingredient,Float> ingredients;
    @Column(nullable = false)
    protected Float cost;
    protected String description;

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
    public void setStandardPrice(){
        Set<Ingredient> ingredients = this.getIngredients().keySet();
        Ingredient[] a;
        Float sum = 0.0f;
        for (Iterator i = ingredients.iterator(); ingredients.iterator().hasNext(); ingredients.iterator().next()){
            Ingredient ingredient = (Ingredient) i.next();
            sum = sum + ingredient.getCost();
        }
        this.cost = sum;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
