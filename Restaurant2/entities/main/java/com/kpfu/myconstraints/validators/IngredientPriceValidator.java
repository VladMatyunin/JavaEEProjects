package com.kpfu.myconstraints.validators;

import com.kpfu.model.ingredient.Ingredient;
import com.kpfu.model.meal.Cookable;
import com.kpfu.myconstraints.annotations.IngredientPrice;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vlad.M on 13.11.2016.
 */
public class IngredientPriceValidator implements ConstraintValidator<IngredientPrice,Cookable> {

    public void initialize(IngredientPrice ingredientPrice) {

    }

    public boolean isValid(Cookable o, ConstraintValidatorContext constraintValidatorContext) {
        Set<Ingredient> ingredients = o.getIngredients().keySet();
        Ingredient[] a;
        Float sum = 0.0f;
        for (Iterator i = ingredients.iterator(); ingredients.iterator().hasNext(); ingredients.iterator().next()){
            Ingredient ingredient = (Ingredient) i.next();
            sum = sum + ingredient.getCost();
        }
        if (sum * 2 > o.getCost() || sum/2 > o.getCost()){
            return false;
        }
        return true;
    }
}
