/**
 * 
 */
package org.jefecomp.message.service.rest.impl;

import java.util.List;

import org.jefecomp.datamodel.entities.user.User;
import org.jefecomp.message.service.UserService;
import org.jefecomp.message.service.impl.UserServiceImpl;
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
public class UserServiceRest implements UserService {
    
    
    private UserServiceImpl userServiceImpl;
    
    
    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
	this.userServiceImpl = userServiceImpl;
    }
    
    
    @Override
    @RequestMapping("/getFollowersList")
    public @ResponseBody List<User> getFollowersList(@RequestParam(value="username") String username) {
	
	return this.userServiceImpl.getFollowersList(username);
    }

    @Override
    @RequestMapping("/getFollowingList")
    public @ResponseBody List<User> getFollowingList(@RequestParam(value="username") String username) {
	
	return this.userServiceImpl.getFollowingList(username);
    }

    @Override
    @RequestMapping("/follow")
    public @ResponseBody boolean follow(@RequestParam(value="username") String username, @RequestParam(value="followerName") String followerName) {
	
	return this.userServiceImpl.follow(username, followerName);
    }

    @Override
    @RequestMapping("/unfollow")
    public @ResponseBody boolean unfollow(@RequestParam(value="username") String username, @RequestParam(value="followerName") String followerName) {
	
	return this.userServiceImpl.unfollow(username, followerName);
    }

    @Override
    @RequestMapping("addUser")
    public @ResponseBody Long addUser(@RequestParam(value="username")String username, @RequestParam(value="password")String password) {
	
	return this.userServiceImpl.addUser(username, password);
    }
}
