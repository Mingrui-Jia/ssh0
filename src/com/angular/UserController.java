package com.angular;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.angular.entity.User;
import com.angular.service.IUserManager;
import com.angular.service.UserManager;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userManager")
	private IUserManager userManager;
	
	@RequestMapping("/checkUserExist")
	public String checkUserExist(User user) {
		System.out.println(userManager.checkUserExist(user));
		if(userManager.checkUserExist(user)){
			System.out.println(userManager.checkUserExist(user));
			return "/userAlreadyExist";
		}
		else return "/addUser";
	}
	
	
	@RequestMapping("/toSaveUser")
	public String toSaveUser(){
		return "/addUser";
	}
	
	@RequestMapping("/checkUser")
	public String check(User user,HttpServletRequest request){
		//System.out.println(user.getUserName());
		  
		if(userManager.checkUser(user)){
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", user.getUserName());
			
			return "/success";
		}else{
			return "/fail";
		}
		
	}

	@RequestMapping("/login")
	public String login(){
		
		return "/login";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(User user){
		userManager.saveUser(user);
		return "/welcome";
	}

}
