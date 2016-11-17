package com.mycompany;

import com.kpfu.model.ingredient.Ingredient;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Created by Vlad.M on 15.11.2016.
 */
@Stateless
public class IngredientRepository extends AbstractCrudRepository<Ingredient,Long> {
    @PostConstruct
   public void init(){
        setClass(Ingredient.class);
    }
}
