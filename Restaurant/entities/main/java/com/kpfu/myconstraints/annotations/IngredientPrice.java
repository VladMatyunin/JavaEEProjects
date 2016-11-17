package com.kpfu.myconstraints.annotations;

import com.kpfu.myconstraints.validators.IngredientPriceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vlad.M on 13.11.2016.
 */

@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IngredientPriceValidator.class)
public @interface IngredientPrice {
    String message() default "Not good price";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

