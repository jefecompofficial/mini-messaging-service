/**
 * 
 */
package org.jefecomp.datamodel.entities.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jefecomp.datamodel.entities.data.Post;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author jefecomp
 *
 */
public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNumber) throws SQLException {
	
	Post post = new Post();
	    
	post.setId(rs.getLong("id"));
	post.setOwner(rs.getString("owner"));
	post.setData(rs.getString("data"));
	    
	return post;
    }
}
