package com.kpfu.myconstraints.annotations;

import com.kpfu.myconstraints.validators.FutureValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vlad.M on 14.11.2016.
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FutureValidator.class)
public @interface Future {
    String message() default "Date is not correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
