/**
 * 
 */
package org.jefecomp.message.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jefecomp.datamodel.entities.user.User;
import org.jefecomp.datamodel.entities.user.dao.UserDao;
import org.jefecomp.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jefecomp
 *
 */
@Component
public class UserServiceImpl implements UserService {
    
    private UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userDao){
	
	this.userDao = userDao;
    }
    
    @Override
    public List<User> getFollowersList(String username) {
	
	User user = this.userDao.getByUsername(username, false, true, false);
	
	if(user != null){
	    
	    Set<User> followersSet = user.getFollowers();
	    
	    return followersSet.stream().collect(Collectors.toList());
	}
	
	return Collections.emptyList();
    }

    @Override
    public List<User> getFollowingList(String username) {
	
	User user = this.userDao.getByUsername(username, false, false, true);
	
	if(user != null){
	    
	    Set<User> followedSet = user.getFollowedUsers();
	    
	    return followedSet.stream().collect(Collectors.toList());
	}
	
	return Collections.emptyList();
    }

    @Override
    public boolean follow(String username, String followerName) {
	
	User user = this.userDao.getByUsername(username, false, false, false);
	
	User follower = this.userDao.getByUsername(followerName, false, false, false);
	
	return this.userDao.getFollowerDao().addFollower(user.getUsername(), follower.getUsername());
    }

    @Override
    public boolean unfollow(String username, String followerName) {
	
	User user = this.userDao.getByUsername(username, false, false, false);
	
	User follower = this.userDao.getByUsername(followerName, false, false, false);
	
	return this.userDao.getFollowerDao().removeFollower(user.getUsername(), follower.getUsername());
    }

    @Override
    public Long addUser(String username, String password) {
	
	return this.userDao.createEntity(new User(username,password));
    }
}