package com.jsp.management.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.management.dto.Branch;
import com.jsp.management.dto.EventName;
import com.jsp.management.dto.User;
import com.jsp.management.service.BrachService;
import com.jsp.management.service.EventNameService;
import com.jsp.management.service.UserService;

@Controller
public class UserVerifiedController {

	@Autowired
	UserService userService;

	@Autowired
	BrachService brachService;

	@Autowired
	AdminController adminController;
	@Autowired
	EventNameService eventNameService;

	@GetMapping("/UserUpdate")
	public ModelAndView UserUpdate() {
		System.out.println("upadte");
		ModelAndView modelAndView = new ModelAndView("UserUpdate.jsp");
		modelAndView.addObject("updateUser", new User());
		return modelAndView;
	}

	@RequestMapping("/updateUserform")
	public ModelAndView updateUserform(@ModelAttribute User user,
			@CookieValue(value = "User_Id", defaultValue = "") String userId) {
		System.out.println("upadtehi");

		int id = Integer.parseInt(userId);
		System.out.println("user id from cookie :" + id);
		System.out.println("update" + id);
		ModelAndView modelAndView = new ModelAndView("UserVerified.jsp");
		System.out.println("form");
		User user2 = userService.getUserById(id);
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setUser_password(user.getUser_password());
		user2.setPayment(user.getPayment());
		User user3 = userService.updateUserById(id, user2);
		modelAndView.addObject("saved", user3.getName() + " saved successfully");
		return modelAndView;
	}

	@RequestMapping("/SelectYourlocation")
	public ModelAndView SelectYourlocation() {
		System.out.println("SelectYourlocation");
		ModelAndView modelAndView = new ModelAndView("UserBranch.jsp");
		List<Branch> branch = brachService.viewAllBranchs();
		for (Branch branch2 : branch) {
			System.out.println(branch2.getLocation());

		}
		modelAndView.addObject("branch", branch);
		return modelAndView;

	}

	@RequestMapping("/location")
	public ModelAndView location(@RequestParam(name = "id") int id,
			@CookieValue(name = "User_Id", defaultValue = "0") int userId, HttpServletResponse response) {
//		List<String> sports=new ArrayList<>();
		User user = userService.getUserById(userId);
		Branch branch = brachService.getBranchById(id);
List<User> users=userService.viewAllUsers();
//List<EventName> eventNames=eventNameService.viewAllEventNames();
		List<EventName> eventNames11 = branch.getEventNames();
		List<Branch> branchs=brachService.viewAllBranchs();
		user.setBranch2(branch);
		user.setBranch(branch.getLocation());
		User user2 = userService.updateUserById(userId, user);
		Branch branch2 = brachService.updateBranchById(id, branch);
		Cookie cookie = new Cookie("Branch_id", String.valueOf(branch2.getId()));
		response.addCookie(cookie);
//		List<Branch> branchs2= new ArrayList<>();
		System.out.println("=================================S");
		System.out.println("location selection");
		for (EventName eventName : eventNames11) {
			// Do something with each eventName
			System.out.println(eventName.getTimeslot1());
			System.out.println(eventName.getTimeslot2());
			System.out.println(eventName.getTimeslot3());
			System.out.println(eventName.getTimeslot4());
			System.out.println(eventName.getSport_name()); // Print the eventName, for example
		}

		ModelAndView modelAndView = new ModelAndView("SelectYourSport.jsp");
		modelAndView.addObject("eventNames11", eventNames11);
		return modelAndView;
	}

	@Transactional
	@RequestMapping("/Selected_Sport_And_Time")
	public ModelAndView selectedSportAndTime(HttpServletRequest request,
			@CookieValue(name = "User_Id", defaultValue = "0") int userId,
			@CookieValue(name = "Branch_id", defaultValue = "0") String Branch_id) {
		ModelAndView modelAndView = new ModelAndView();
		int b_id = Integer.parseInt(Branch_id);
		Branch branch = brachService.getBranchById(b_id);
		User user = userService.getUserById(userId);
		List<User> users = userService.viewAllUsers();
		List<EventName> eventNames = eventNameService.viewAllEventNames();
		int sum= 0;
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			if (paramName.startsWith("selectedTimeslot_")) {
				String eventId = paramName.substring("selectedTimeslot_".length());
				String timeslot = request.getParameter(paramName);
				System.out.println("===============================");
				System.out.println();
				System.out.println("Event ID: " + eventId + ", Selected Timeslot: " + timeslot);
				System.out.println("===============================");
				System.out.println();
				int id = Integer.parseInt(eventId);
				EventName eventName = eventNameService.getEventNameById(id);
				
				System.out.println("=============================");
				System.out.println();
			System.out.println(eventName.getCharges());	
				int countToUpdate = -1; // Placeholder value to determine which timeslot to update
				if (timeslot.equalsIgnoreCase("Afternoon")) {
					countToUpdate = eventName.getTimeslot2();
				
				} else if (timeslot.equalsIgnoreCase("Morning")) {
					countToUpdate = eventName.getTimeslot1();
					
				} else if (timeslot.equalsIgnoreCase("Evening")) {
					countToUpdate = eventName.getTimeslot3();
					
				} else if (timeslot.equalsIgnoreCase("24*7")) {
					countToUpdate = eventName.getTimeslot4();		
				
				}
				if (countToUpdate != -1) {
					countToUpdate++;
					switch (timeslot.toLowerCase()) {
					case "afternoon":
						eventName.setTimeslot2(countToUpdate);
						System.out.println("===================");
						System.out.println();
						System.out.println(eventName.getTimeslot2());
						sum =sum+eventName.getCharges();
						System.out.println("====================");
						System.out.println(sum +" afrernoon");
						System.out.println("====================");
						
						break;
					case "morning":
						eventName.setTimeslot1(countToUpdate);
						System.out.println("===================");
						System.out.println();
						System.out.println(eventName.getTimeslot1());
						sum =sum+eventName.getCharges();
						System.out.println("====================");
						System.out.println(sum +" morning");
						System.out.println("====================");
						break;
					case "evening":
						eventName.setTimeslot3(countToUpdate);
						System.out.println("===================");
						System.out.println();
						System.out.println(eventName.getTimeslot3());
						sum =sum+eventName.getCharges();
						System.out.println("====================");
						System.out.println(sum +"Evening");
						System.out.println("====================");
						break;
					case "24*7":
						eventName.setTimeslot4(countToUpdate);
						System.out.println("===================");
						System.out.println();
						System.out.println(eventName.getTimeslot4());
						sum =sum+(eventName.getCharges()*4);
						System.out.println("====================");
						System.out.println(sum +"24*7");
						System.out.println("====================");
						break;
					}

					EventName updatedEventName = eventNameService.updateEventNameById(id, eventName);
	                updatedEventName.setUsers(users);
	                updatedEventName.setBranch(branch);
	                branch.setEventNames(branch.getEventNames()); // Might not need this line
	                branch.setUsers(users);
	              
	                user.setCharges(sum);
					User user2 = userService.updateUserById(userId, user);
					Branch branch2 = brachService.updateBranchById(b_id, branch);

					// No need to set users again for eventName2

					// Assuming eventNameService.updateEventNameById returns the updated entity
				}
			}
		}
		 modelAndView.addObject("user", user); // Pass the user object to the view
		    modelAndView.addObject("charges", sum); // Pass the total charges to the view
		    modelAndView.setViewName("confirmationPage.jsp"); // Set the view name

		return modelAndView;
	}

//	@RequestMapping("/UserViewById")
//	public ModelAndView UserViewById(@CookieValue(value = "User_Id", defaultValue = "") String userId) {
//		System.out.println("UserViewById");
//		
//		ModelAndView modelAndView = new ModelAndView("UserViewById.jsp");
//		System.out.println("UserViewByIdhi");
//		modelAndView.addObject("userbyId", new User());
//		return modelAndView;
//	}

	@RequestMapping("/UserViewById")
	public ModelAndView UserViewById(@CookieValue(value = "User_Id", defaultValue = "") String userId) {
		int id = Integer.parseInt(userId);
		System.out.println(id);
	    ArrayList<Object> al=new ArrayList();
		User user = userService.getUserById(id);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getPayment());
		System.out.println(user.getUser_password());
		System.out.println(user.getBranch());
		System.out.println(user.getCharges());
		System.out.println(user.getEventNames());
		List<EventName> eventNames=user.getEventNames();
		for (EventName eventName : eventNames) {
			System.out.println(eventName);
		}
		
		al.add(user.getId());
		al.add(user.getName());
		System.out.println("UserViewById details");
//		User user2=userService.updateUserById(id, user);
		ModelAndView modelAndView = new ModelAndView("UserDetails.jsp");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	 @PostMapping("/makePayment")
	 public ModelAndView makePayment(@RequestParam String amount, @ModelAttribute User user, @CookieValue(value = "User_Id", defaultValue = "") String userId) {
		    int id = Integer.parseInt(userId);
		  
		    int paymentAmount = Integer.parseInt(amount);
	  User user2=userService.getUserById(id);
	  
	  if(user2.getCharges()==paymentAmount) {
		  
		  user2.setPayment("paid");
		  User user3=userService.updateUserById(id, user2);

	        ModelAndView modelAndView= new ModelAndView("SubscritionSuccessfull.jsp");
	        return  modelAndView;
	  }
	  else {
		  user2.setPayment("unpaid");
		  User user3=userService.updateUserById(id, user2);

	        ModelAndView modelAndView= new ModelAndView("SubscritionUnSuccessfull.jsp");
	        return  modelAndView;
	  }
	     
	    }
}
