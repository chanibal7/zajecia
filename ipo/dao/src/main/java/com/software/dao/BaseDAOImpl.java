/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-dao
 *
 *  @author: Andrzej Piechocki           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDAOImpl<T extends Serializable> implements BaseDAO<T> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void create(final T entity) {
        em.persist(entity);
    }

    @Override
    public void delete(final T entity) {
        em.remove(entity);
    }

    @Override
    public T update(final T entity) {
        return em.merge(entity);
    }

    @Override
    public T updateWithFlush(final T entity) {
        final T merge = em.merge(entity);
        em.flush();
        return merge;
    }
}