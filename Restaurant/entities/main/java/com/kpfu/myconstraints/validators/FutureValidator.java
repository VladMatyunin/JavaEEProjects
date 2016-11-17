package com.kpfu.myconstraints.validators;

import com.kpfu.model.orders.Order;
import com.kpfu.myconstraints.annotations.Future;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * Created by Vlad.M on 14.11.2016.
 */
public class FutureValidator implements ConstraintValidator<Future, Order> {
    public void initialize(Future future) {
    }

    public boolean isValid(Order order, ConstraintValidatorContext constraintValidatorContext) {
        if (order.getDelivery_date().getTime() > new Date().getTime()){
            return false;
        }
        return true;
    }
}
