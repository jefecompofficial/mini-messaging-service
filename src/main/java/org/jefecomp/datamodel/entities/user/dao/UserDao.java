/**
 * 
 */
package org.jefecomp.datamodel.entities.user.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.jefecomp.datamodel.dao.AbstractDao;
import org.jefecomp.datamodel.dao.Dao;
import org.jefecomp.datamodel.entities.user.User;
import org.jefecomp.datamodel.entities.user.dao.query.UserNamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jefeoomp
 *
 */
@Component
public class UserDao extends AbstractDao implements Dao<User> {
    
    	private String USERNAME="username";
    	
    	private String PASSWORD="password";
    
    	private FollowerDao followerDao;
    
    	@Autowired
    	public void setFollowerDao(FollowerDao followerDao){
    	    this.followerDao = followerDao;
    	}
    	
    	public FollowerDao getFollowerDao(){
    	    
    	    return this.followerDao;
    	}
    	
	private void addFollowers(User user){
	    
	    if(user.getUsername() != null){
		
		List<User> followers = followerDao.getFollowers(user.getUsername());
		
		user.setFollowers(followers != null ? new HashSet<>(followers) : Collections.emptySet());
	    }
	    
	}
	
	private void addFollowingUser(User user){
	    
	    if(user.getUsername() != null){
		
		List<User> followingUsers = followerDao.getFollowedUsers(user.getUsername());
		
		user.setFollowedUsers(followingUsers != null ? new HashSet<>(followingUsers) : Collections.emptySet());
	    }
	}
	
	private String hashPassword(String password) throws IOException{
	    
	    byte[] passwordBytes = password.getBytes();

	    Digest sha1Digest = new SHA1Digest();

	    sha1Digest.update(passwordBytes, 0, passwordBytes.length);

	    byte[] digest = new byte[sha1Digest.getDigestSize()];

	    sha1Digest.doFinal(digest, 0);
	    
	    Base64Encoder encoder = new Base64Encoder();

	    ByteArrayOutputStream resultOs = new ByteArrayOutputStream();
	    
	    encoder.encode(digest, 0, digest.length, resultOs);
	    
	    return resultOs.toString();
	}
    
    
	@Override
	public User getById(Long id) {
		
//	    Not implemented by User Dao as the identifier of a User is a username
	    
	    return null;
	}
	
	@Override
	public Long createEntity(User entity) {
	    
	    try{
		
		entity.setPassword(this.hashPassword(entity.getPassword()));
	    }
	    catch(IOException e){
		
		e.printStackTrace();
		
		return -1L;
	    }
	    
	    Map<String,Object> params = new HashMap<>();
	    
	    params.put(this.USERNAME, entity.getUsername());
	    
	    params.put(this.PASSWORD, entity.getPassword());
	    
	    boolean isInserted = this.getNamedParameterTemplate().update(UserNamedQuery.INSERT_USER.query(), params) > 0;
	    
	    if(!isInserted){
		
		return -1L;
	    }
	    
	    if(entity.getFollowers() != null && !entity.getFollowers().isEmpty()){
		
		entity.getFollowers().stream().forEach(follower -> {
		    
		    this.followerDao.addFollower(entity.getUsername(), follower.getUsername());
		});		
	    }
	    
	    if(entity.getFollowedUsers() != null && !entity.getFollowedUsers().isEmpty()){
		
		entity.getFollowedUsers().stream().forEach(followedUser ->{
		    
		    this.followerDao.addFollower(followedUser.getUsername(), entity.getUsername());
		    
		});
	    }
	    
	    return 0L;
	}

	@Override
	public boolean updateEntity(User entity) {
	    
	    
	    return false;
	}
	
	@Override
	public boolean deleteEntity(Long id) {
	    
//	    Not applicable to UserDao as User entity uses username as identifier
	    
	    return false;
	}
	
	public User getByUsername(String username, boolean auth, boolean includeFollowers, boolean includeFollowing){
	    
	    User user = this.getNamedParameterTemplate().query(UserNamedQuery.GET_BY_USERNAME.query(), Collections.singletonMap(this.USERNAME, username), new UserResultSetExtractor(auth));
	    
	    if(includeFollowers){
		
		this.addFollowers(user);
	    }
	    
	    if(includeFollowing){
		
		this.addFollowingUser(user);
	    }
	    
	    return user;
 	}
}