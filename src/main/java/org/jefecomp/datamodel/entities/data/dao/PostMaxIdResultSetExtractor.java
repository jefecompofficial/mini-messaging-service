/**
 * 
 */
package org.jefecomp.datamodel.entities.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jefecomp.datamodel.entities.data.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * @author jefecomp
 *
 */
public class PostMaxIdResultSetExtractor implements ResultSetExtractor<Post> {

    @Override
    public Post extractData(ResultSet rs) throws SQLException, DataAccessException {
	
	Post post = new Post();
	
	if(rs.first()){
	    
	    post.setId(rs.getLong("id"));
	}
	
	return post;
    }
}
