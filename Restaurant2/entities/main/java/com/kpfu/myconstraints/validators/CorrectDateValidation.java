package com.kpfu.myconstraints.validators;

import com.kpfu.model.orders.Order;
import com.kpfu.myconstraints.annotations.CorrectDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Vlad.M on 14.11.2016.
 */
public class CorrectDateValidation implements ConstraintValidator<CorrectDate, Order> {
    public void initialize(CorrectDate correctDate) {

    }

    public boolean isValid(Order order, ConstraintValidatorContext constraintValidatorContext) {
        if (order.getDate().getTime() > order.getDelivery_date().getTime()){
            return false;
        }
        return true;
    }
}
