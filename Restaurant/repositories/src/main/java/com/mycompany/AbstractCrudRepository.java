package com.mycompany;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Vlad.M on 14.11.2016.
 */
public abstract class AbstractCrudRepository<T,K> implements MyCrudRepository<T,K> {
    private Class<T> TYPE;
    @PersistenceContext(name = "restaurant_entity")
    EntityManager entityManager;
    @Inject
    T entity;
    protected void setClass(Class<T> tClass){
        TYPE = tClass;
    }
    public Class<T> getAClass(){
        return TYPE;
    }
    @Override
    public T getById(K id) {
        return entityManager.find(TYPE,id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(TYPE);
        Root<T> root = query.from(TYPE);
        CriteriaQuery<T> all = query.select(root);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public boolean deleteById(K id) {
        if (getById(id)==null) return false;
        entityManager.remove(getById(id));
        return true;
    }

    @Override
    public boolean add(T o) {
        if (contains(o)) return false;
        entityManager.persist(o);
        return true;
    }

    @Override
    public boolean update(T o) {
        if (!contains(o)) return false;
        entityManager.refresh(o);
        return true;
    }
    public boolean contains(T o){
        if (entityManager.contains(o)) return true;
        return false;
    }
}
