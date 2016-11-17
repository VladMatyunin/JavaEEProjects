package com.mycompany;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Vlad.M on 14.11.2016.
 */
@Remote
public interface MyCrudRepository<T,K> {
    T getById(K id);
    List<T> getAll();
    boolean deleteById(K id);
    boolean add(T o);
    boolean update(T o);
}
