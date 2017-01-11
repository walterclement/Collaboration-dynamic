package com.blogback.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogback.dao.UserDao;
import com.blogback.model.User;
import com.blogback.model.UserErr;
import com.blogback.services.UserService;

@RestController
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//isOnline - set true when the user login
	//isOnline -set false when the user logout
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session){
		// ? means it can return any type of object [Error, User]
		
		// the method login has to return any Type  
		//if the user is invalid - return Error object with status code
		//if the user is valid  - return User object with status code
		logger.debug("Entering USERCONTROLLER : LOGIN");
		User validUser=userDao.authenticate(user);
		if(validUser==null){
			UserErr error=new UserErr(1,"Username and password doesnt exists...");
			return new ResponseEntity<UserErr>(error,HttpStatus.UNAUTHORIZED); //401
		}
		else{
			//key [user] value [validUser-an object of type User]
			session.setAttribute("user", validUser);
			validUser.setOnline(1);
			userDao.updateUser(validUser); // to update online status in db
			logger.debug("validUser is not null");
			return new ResponseEntity<User>(validUser,HttpStatus.OK);//200
		}
	}
	
	@RequestMapping(value="/allUsers",method=RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
		public ResponseEntity<?> registeruser(@RequestBody User user){
		
			logger.debug("USERCONTROLLER=>REGISTER " + user);
			user.setEnable(1);
			user.setOnline(0);
			User savedUser=userDao.registerUser(user);
			
				if(savedUser.getUserid()==0){
					UserErr error=new UserErr(2,"Couldnt insert user Details");
					return new ResponseEntity<UserErr>(error,HttpStatus.CONFLICT);
						}
				else{
						return new ResponseEntity<User>(savedUser,HttpStatus.OK);
					}
				}
	
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session)
	{
		User user=(User) session.getAttribute("user");
		if(user!=null){
			user.setOnline(0);
			userDao.updateUser(user);
		}
		session.removeAttribute("user");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}