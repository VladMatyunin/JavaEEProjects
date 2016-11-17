package com.mycompany;

import com.kpfu.model.users.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Created by Vlad.M on 14.11.2016.
 */
@Stateless
public class UserRepositoryEJB extends AbstractCrudRepository<User,Long> {
    public UserRepositoryEJB(){}
    @PostConstruct
    public void init(){
        setClass(User.class);
    }
}
