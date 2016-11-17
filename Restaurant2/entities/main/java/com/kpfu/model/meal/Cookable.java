package com.kpfu.model.meal;

import com.kpfu.model.ingredient.Ingredient;

import java.util.Map;

/**
 * Created by Vlad.M on 12.11.2016.
 */
public interface Cookable {
    Map<Ingredient,Float> getIngredients();
    Float getCost();
}
