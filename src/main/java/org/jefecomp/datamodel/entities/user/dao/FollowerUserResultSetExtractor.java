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
public class FollowerUserResultSetExtractor implements ResultSetExtractor<User> {
    
    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
	
	User user = new User();
	
	user.setUsername(rs.getString("username"));
	
	return user;
    }
}
