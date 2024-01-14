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

public interface BaseDAO<T extends Serializable> {

    void create(T entity);

    void delete(T entity);

    T update(T entity);

    T updateWithFlush(final T entity);
}
