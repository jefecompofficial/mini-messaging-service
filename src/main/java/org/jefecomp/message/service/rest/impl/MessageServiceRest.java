/**
 * 
 */
package org.jefecomp.message.service.rest.impl;

import java.util.List;

import org.jefecomp.datamodel.entities.data.Post;
import org.jefecomp.message.service.MessageService;
import org.jefecomp.message.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jefecomp
 *
 */
@RestController
public class MessageServiceRest implements MessageService{

    @Autowired
    private MessageServiceImpl messageServiceImpl;
    
    @Override
    @RequestMapping("/addPost")
    public @ResponseBody Long addPost(@RequestParam(value="username")String owner, @RequestParam(value="data") String data) {
	return this.messageServiceImpl.addPost(owner,data);
    }


    @Override
    @RequestMapping("/deletePost")
    public @ResponseBody boolean deletePost(@RequestParam(value="postId") Long postId) {
	return this.messageServiceImpl.deletePost(postId);
    }


    @Override
    @RequestMapping("/updatePost")
    public @ResponseBody boolean updatePost(@RequestParam(value="postId")Long postId, @RequestParam(value="data")String data) {
	
	return this.messageServiceImpl.updatePost(postId, data);
    }


    @Override
    @RequestMapping("/getPosts")
    public @ResponseBody List<Post> getPosts(@RequestParam(value="username") String owner, @RequestParam(value="search", required=false)String search) {
	
	return this.messageServiceImpl.getPosts(owner, search);
    }


    @Override
    @RequestMapping("/getPostsOfFollowedUsers")
    public @ResponseBody List<Post> getPostsOfFollowedUsers(@RequestParam(value="username") String owner, @RequestParam(value="search",required=false)String search) {
	
	return this.messageServiceImpl.getPostsOfFollowedUsers(owner, search);
    }
}