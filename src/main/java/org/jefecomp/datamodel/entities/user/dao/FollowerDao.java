/**
 * 
 */
package org.jefecomp.datamodel.entities.user.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jefecomp.datamodel.dao.AbstractDao;
import org.jefecomp.datamodel.dao.Dao;
import org.jefecomp.datamodel.entities.user.User;
import org.jefecomp.datamodel.entities.user.dao.query.FollowerNamedQuery;
import org.springframework.stereotype.Component;

/**
 * @author jefecomp
 *
 */
@Component
public class FollowerDao extends AbstractDao implements Dao<User> {
    
    private String USERNAME="username";
    
    private String FOLLOWERNAME="followerName";
    
    
    @Override
    public User getById(Long id) {
	
	// Not applicable to FollowerDao
	
	return null;
    }

    @Override
    public boolean deleteEntity(Long id) {
	
//	Not applicable to FollowerDao
	
	return false;
    }
    
    @Override
    public Long createEntity(User entity) {
	
//	Not applicable to FollowerDao 
	
	return null;
    }

    @Override
    public boolean updateEntity(User entity) {
	
//	Not applicable to FollowerDao
	
	return false;
    }
    
    public boolean addFollower(String username, String followerName){
	
	Map<String,Object> parameters = new HashMap<>();
	
	parameters.put(this.USERNAME, username);
	
	parameters.put(this.FOLLOWERNAME, followerName);
	
	
	return this.getNamedParameterTemplate().update(FollowerNamedQuery.INSERT_FOLLOWER.query(), parameters) > 0;
    }
    
    public boolean removeFollower(String username, String followerName){
	
	Map<String,Object> parameters = new HashMap<>();
	
	parameters.put(this.USERNAME, username);
	
	parameters.put(this.FOLLOWERNAME, followerName);
	
	
	return this.getNamedParameterTemplate().update(FollowerNamedQuery.INSERT_FOLLOWER.query(), parameters) > 0;
	
    }
    
    public boolean isFollowing(String username, String followerName){
	
	Map<String,Object> params = new HashMap<>();
	
	params.put(this.USERNAME, username);
	params.put(this.FOLLOWERNAME, followerName);
	
	return this.getNamedParameterTemplate().query(FollowerNamedQuery.IS_FOLLOWING.query(), params, new FollowerUserResultSetExtractor()) != null;
    }
    
    public List<User> getFollowers(String username){
	
	return this.getNamedParameterTemplate().query(FollowerNamedQuery.GET_FOLLOWERS.query(),Collections.singletonMap(this.USERNAME, username), new FollowerRowMapper());
    }
    
    public List<User> getFollowedUsers(String username){
	
	return this.getNamedParameterTemplate().query(FollowerNamedQuery.GET_FOLLOWED_USERS.query(),Collections.singletonMap(this.USERNAME, username), new FollowerRowMapper());
    }   
}
