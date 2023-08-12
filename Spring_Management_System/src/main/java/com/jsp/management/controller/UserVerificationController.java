package com.jsp.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jsp.management.dto.Branch;
import com.jsp.management.dto.EventName;
import com.jsp.management.dto.User;
import com.jsp.management.service.BrachService;
import com.jsp.management.service.EventNameService;
import com.jsp.management.service.UserService;

@Controller
public class UserVerificationController {
@Autowired
UserService userService;
	
@Autowired
BrachService brachService;

@Autowired
AdminController adminController; 
@Autowired
EventNameService eventNameService;

List<User> users=new ArrayList<>();
	@RequestMapping("/ToSaveUser")
	public ModelAndView UserSave() {
		ModelAndView modelAndView = new ModelAndView("UserSave.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}
	@RequestMapping("/SaveUser")
	public ModelAndView saveStudent(@ModelAttribute User user ,  HttpServletResponse response) {
	int id1=user.getId();
	System.out.println(user.getName());
		user.setPayment("unapproved");
		System.out.println(id1);
		User user2=userService.saveUser(user);
		
		
		users.add(user2);
		int id=user2.getId();
		 Cookie idCookie = new Cookie("userId", String.valueOf(id));
		 response.addCookie(idCookie);
		List<Branch> branchs=brachService.viewAllBranchs();
		ModelAndView modelAndView = new ModelAndView("UserVerification.jsp");
		modelAndView.addObject("branch", branchs);
		
		modelAndView.addObject("saved", user2.getName() + " saved successfully");
		return modelAndView;
	}
	
	@RequestMapping("/ToLogin")
	public ModelAndView ToLogin() {
		ModelAndView modelAndView = new ModelAndView("UserLogin.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}
	
	@RequestMapping("/UserLoginForm")
	public ModelAndView UserLoginForm(@ModelAttribute User user , HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("UserVerified.jsp");
		int id= user.getId();
		System.out.println(id);
		String password=user.getUser_password();
		System.out.println(password);
		User user2=userService.getUserById(id);
		System.out.println(user2.getUser_password());
		if(password.equals(user2.getUser_password())) {
			ModelAndView modelAndView1 = new ModelAndView("UserVerified.jsp");
			Cookie cookie= new Cookie("User_Id", String.valueOf(id) );
			response.addCookie(cookie);
			modelAndView.addObject("saved", user2.getName() + " saved successfully");
			return modelAndView1;
		}
		else {
			ModelAndView modelAndView1 = new ModelAndView("UserLogin.jsp");
			modelAndView.addObject("saved", user2.getName() + " saved successfully");
			return modelAndView1;
			
		}
		
	}
}
