/**
 * 
 */
package org.jefecomp.message.service;

import java.util.List;

import org.jefecomp.datamodel.entities.user.User;

/**
 * @author jefecomp
 *
 */
public interface UserService {

	
    	Long addUser(String username,String password);
    
	List<User> getFollowersList(String username);
	
	List<User> getFollowingList(String username);
	
	boolean follow(String username, String followerName);
	
	boolean unfollow(String username, String followerName);
}
