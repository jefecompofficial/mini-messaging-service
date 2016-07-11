/**
 * 
 */
package org.jefecomp.datamodel.entities.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jefecomp.datamodel.entities.user.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * @author jefecomp
 *
 */
public class UserResultSetExtractor implements ResultSetExtractor<User> {

    private boolean auth;
    
    
    public UserResultSetExtractor() {
	
	this(false);
    }
    
    public UserResultSetExtractor(boolean auth) {
	
	this.auth = auth;
    }
    
    
    
    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
	
	if(rs.first()){
	
    		User user = new User();
    	
    		user.setUsername(rs.getString("username"));
    	
    		if(auth){
    	    
    		    user.setPassword(rs.getString("password"));
    		}
    	
    		return user;
	}
	
	return null;
    }

}
