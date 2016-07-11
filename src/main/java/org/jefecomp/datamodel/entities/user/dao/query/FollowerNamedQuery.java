/**
 * 
 */
package org.jefecomp.datamodel.entities.user.dao.query;

/**
 * @author jefecomp
 *
 */
public enum FollowerNamedQuery {
    
    IS_FOLLOWING("Select u.username from User u inner join Follower f on f.followerName=u.username Where f.username = :username and f.followerName = :followerName"),
    
    GET_FOLLOWERS("Select u.username from User u inner join Follower f on f.followerName=u.username Where f.username = :username"),
    
    GET_FOLLOWED_USERS("Select u.username from User u inner join Follower f on f.username=u.username Where f.followerName = :username"),
    
    INSERT_FOLLOWER("Insert into Follower(username,followerName) values(:username, :followerName)"),
    
    REMOVE_FOLLOWER("Delete from Follower Where username = :username AND followerName = :followerName");
    
    private String query;
    
    private FollowerNamedQuery(String query) {
	
	this.query = query;
    }

    public String query(){
	
	return this.query;
    }
    
}