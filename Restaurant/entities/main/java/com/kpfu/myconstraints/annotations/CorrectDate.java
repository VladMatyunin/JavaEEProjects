package com.kpfu.myconstraints.annotations;

import com.kpfu.myconstraints.validators.CorrectDateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vlad.M on 14.11.2016.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectDateValidation.class)
public @interface CorrectDate {
    String message() default "Wrong dates of order";
    Class<? extends Payload>[] payload() default {};
    Class<?>[] groups() default {};

}
