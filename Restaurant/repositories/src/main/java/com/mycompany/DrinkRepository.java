package com.mycompany;


import com.kpfu.model.meal.Drink;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Created by Vlad.M on 15.11.2016.
 */
@Stateless
public class DrinkRepository extends AbstractCrudRepository<Drink,Long> {
    @PostConstruct
    public void init(){
        setClass(Drink.class);
    }
}
