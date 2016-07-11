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
public class PostResultSetExtractor implements ResultSetExtractor<Post> {

    @Override
    public Post extractData(ResultSet rs) throws SQLException, DataAccessException {
	
	if(rs.first()){
	    
	    Post post = new Post();
	    
	    post.setId(rs.getLong("id"));
	    post.setOwner(rs.getString("owner"));
	    post.setData(rs.getString("data"));
	    
	    return post;
	}
	
	return null;
    }

}
