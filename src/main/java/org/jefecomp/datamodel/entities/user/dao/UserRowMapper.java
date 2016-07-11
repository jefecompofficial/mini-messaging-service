/**
 * 
 */
package org.jefecomp.datamodel.entities.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jefecomp.datamodel.entities.user.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author jefecomp
 *
 */
public class UserRowMapper implements RowMapper<User> {

    private boolean auth;
    
    public UserRowMapper() {
	this(false);
    }
    
    public UserRowMapper(boolean auth) {
	
	this.auth = auth;
    }
    
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	User user = new User();
	
	user.setUsername(rs.getString("username"));
	
	if(this.auth){
	    
	    user.setPassword(rs.getString("password"));
	}
	
	return user;
    }

}
