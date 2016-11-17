package com.mycompany;

import com.kpfu.model.meal.Meal;
import com.kpfu.model.meal.Meal_Id;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Created by Vlad.M on 15.11.2016.
 */
@Stateless
public class MealRepository extends AbstractCrudRepository<Meal,Meal_Id> {
    @PostConstruct
    public void init(){
        setClass(Meal.class);
    }
}
