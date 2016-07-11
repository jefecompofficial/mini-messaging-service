/**
 * 
 */
package org.jefecomp.message.service;

import java.util.List;

import org.jefecomp.datamodel.entities.data.Post;

/**
 * @author jefecomp
 *
 */
public interface MessageService {
	
	Long addPost(String owner, String data);
	
	boolean deletePost(Long postId);
	
	boolean updatePost(Long postId, String data);
    
    	List<Post> getPosts(String owner, String search);
	
	List<Post> getPostsOfFollowedUsers(String owner, String search);
}
