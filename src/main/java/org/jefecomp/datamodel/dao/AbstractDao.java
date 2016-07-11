/**
 * 
 */
package org.jefecomp.datamodel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author jefecomp
 *
 */
public abstract class AbstractDao {

    	private NamedParameterJdbcTemplate namedParameterTemplate;
	
	@Autowired
	public void setNamedParameterTemplate(NamedParameterJdbcTemplate namedParameterTemplate){
		
		this.namedParameterTemplate = namedParameterTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterTemplate(){
		
		return this.namedParameterTemplate;
	}
}