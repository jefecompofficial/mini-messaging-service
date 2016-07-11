/**
 * 
 */
package org.jefecomp.datamodel.dao;

/**
 * @author jefecomp
 *
 */
public interface Dao<E> {
	
	E getById(Long id);
	
	Long createEntity(E entity);
	
	boolean updateEntity(E entity);
	
	boolean deleteEntity(Long id);
}
