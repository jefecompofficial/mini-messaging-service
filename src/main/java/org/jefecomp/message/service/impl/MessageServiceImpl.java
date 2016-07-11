/**
 * 
 */
package org.jefecomp.message.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.jefecomp.datamodel.entities.data.Post;
import org.jefecomp.datamodel.entities.data.dao.PostDao;
import org.jefecomp.datamodel.entities.user.User;
import org.jefecomp.datamodel.entities.user.dao.UserDao;
import org.jefecomp.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jefecomp
 *
 */
@Component
public class MessageServiceImpl implements MessageService {

    private PostDao postDao;
    
    private UserDao userDao;
    
    @Autowired
    public void setPostDao(PostDao postDao){
	
	this.postDao = postDao;
    }
    
    
    @Autowired
    public void setUserDao(UserDao userDao){
	
	this.userDao = userDao;
    }


    @Override
    public Long addPost(String owner, String data) {
	return this.postDao.createEntity(new Post(owner,data));
    }


    @Override
    public boolean deletePost(Long postId) {
	return this.postDao.deleteEntity(postId);
    }

    @Override
    public boolean updatePost(Long postId, String data) {
	
	Post post = new Post();
	
	post.setId(postId);
	post.setData(data);
	
	return this.postDao.updateEntity(post);
    }


    @Override
    public List<Post> getPosts(String owner, String search) {
	
	return this.postDao.getPostsByOwner(owner, search);
    }


    @Override
    public List<Post> getPostsOfFollowedUsers(String owner, String search) {
	
	User user = this.userDao.getByUsername(owner, false, false, true);
	
	List<String> owners = new ArrayList<>();
	
	if(!user.getFollowedUsers().isEmpty()){
	    
	    owners.addAll(user.getFollowedUsers().stream().map(followedUser -> followedUser.getUsername()).collect(Collectors.toList()));
	}
	else{
	    
	    return Collections.emptyList();
	}
	
	
	return this.postDao.getPostsByOwnerList(owners, search);
    }
}
