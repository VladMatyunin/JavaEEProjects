package com.mycompany;

import com.kpfu.model.orders.Order;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Created by Vlad.M on 15.11.2016.
 */
@Stateless
public class OrderRepository extends AbstractCrudRepository<Order,Long> {
    @PostConstruct
    public void init(){
        setClass(Order.class);
    }
}
