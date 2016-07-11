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
public class FollowerRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	    User user = new User();
	
	    user.setUsername(rs.getString("username"));
	
	    return user;
    }
}
