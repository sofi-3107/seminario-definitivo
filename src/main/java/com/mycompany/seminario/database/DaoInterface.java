
package com.mycompany.seminario.database;

import java.util.List;

/**
 *
 * @author Sofi
 */
public interface DaoInterface <T>{
    
    
    public List<T>getAll();
    
    public T findById(T o);
    
    public void create(T o);
    
    public void delete(T o);
    
    public void update(T o, T p);
    
}
