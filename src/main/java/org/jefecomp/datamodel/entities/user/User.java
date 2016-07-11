/**
 * 
 */
package org.jefecomp.datamodel.entities.user;

import java.util.Set;

/**
 * @author jefecomp
 *
 */

public class User {
    
    private String username;
    
    private String password;
    
    private Set<User> followers;
    
    private Set<User> followedUsers;
    
    public User() {}
    
    public User(String username, String password){
	
	this.username = username;
	
	this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(Set<User> followedUsers) {
        this.followedUsers = followedUsers;
    }
}