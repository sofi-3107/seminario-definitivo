package com.mycompany.seminario.hibernatedao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sofy
 */
public interface GenericDao<T, ID extends Serializable> {

  

    void saveOrUpdate(T entity) throws Exception;

    T getId(ID id) throws Exception;

    void delete(ID id) throws Exception;

    List<T> findAll() throws Exception;

}
