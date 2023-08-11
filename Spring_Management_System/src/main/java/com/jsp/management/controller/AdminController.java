package com.jsp.management.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.management.dto.Admin;
import com.jsp.management.dto.Branch;
import com.jsp.management.dto.EventName;
import com.jsp.management.dto.User;
import com.jsp.management.service.AdminService;
import com.jsp.management.service.BrachService;
import com.jsp.management.service.EventNameService;
import com.jsp.management.service.UserService;


@Controller
public class AdminController {
	@Autowired
	AdminService adminService;

	@Autowired
	BrachService brachService;

	@Autowired
	EventNameService eventNameService;
@Autowired
UserService userService;
	List<Branch> b_list = new ArrayList<>();
	List<String> Sportslist = new ArrayList<>();
//	Map<String, List<String>> sportsLists = new HashMap<>();	

	@RequestMapping("/adminload")
	public ModelAndView studentLoad() {
		ModelAndView modelAndView = new ModelAndView("adminSave.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;

	}

	@RequestMapping("/adminadd")
	public ModelAndView saveStudent(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		Admin admin2 = adminService.saveAdmin(admin);
		modelAndView.addObject("saved", admin2.getName() + " saved successfully");
		return modelAndView;
	}

	@GetMapping("/updateAdmin")
	public ModelAndView updateAdmin() {
		ModelAndView modelAndView = new ModelAndView("updateAdmin.jsp");
		modelAndView.addObject("updateAdmin", new Admin());
		return modelAndView;
	}

	@RequestMapping("/updateAdminform")
	public ModelAndView updateAdminById(@ModelAttribute Admin admin) {
		int id = admin.getId();
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		Admin admin2 = adminService.updateAdminById(id, admin);
		modelAndView.addObject("saved", admin2.getName() + " saved successfully");
		return modelAndView;
	}

	@GetMapping("/deleteAdmin")
	public ModelAndView deleteAdmin() {
		ModelAndView modelAndView = new ModelAndView("deleteAdmin.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;
	}

	@RequestMapping("/deleteAdminform")
	public ModelAndView deleteAdminById(@ModelAttribute Admin admin) {
		int id = admin.getId();
		boolean b = adminService.deleteAdminById(id);
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		return modelAndView;
	}

	@RequestMapping("/setBranch")
	public ModelAndView setBranch() {
		ModelAndView modelAndView = new ModelAndView("BranchSave.jsp");
		modelAndView.addObject("branch", new Branch());
		return modelAndView;

	}

	@RequestMapping("/saveBranch")
	public ModelAndView setBranch(@ModelAttribute Branch branch,
			@RequestParam(value = "selectedActivities", required = false) String[] selectedActivities) {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");

		Branch branch2 = brachService.saveBranch(branch);
		int id = branch2.getId();
		List<EventName> sportsListItems = new ArrayList<>();
		branch2.setEventNames(sportsListItems);
//	sportsListItems.add("check");
//	sportsLists.put(String.valueOf(id), sportsListItems);

		b_list.add(branch2);
		modelAndView.addObject("saved", branch2.getLocation() + " saved successfully");
		return modelAndView;
	}

	@RequestMapping("/setSport")
	public ModelAndView setSport() {
		System.out.println("set sport");
		ModelAndView modelAndView = new ModelAndView("BranchSelect.jsp");
		modelAndView.addObject("branch", new Branch());
		System.out.println(999);
		System.out.println(932);
		return modelAndView;

	}

	@RequestMapping("/SelectBranch")
	public ModelAndView SelectBranch( @ModelAttribute Branch branch ,HttpServletResponse response) {
		int id =branch.getId();
		Cookie cookie= new Cookie("Branch_Id", String.valueOf(id));
		response.addCookie(cookie);
		ModelAndView modelAndView = new ModelAndView("BranchSetSport.jsp");
		System.out.println(999);
		modelAndView.addObject("eventName", new EventName());
		System.out.println(932);

		return modelAndView;

	}

	@RequestMapping("/SetSportBranchform")
	public ModelAndView SelectBranch(@ModelAttribute EventName eventName, @CookieValue(name = "Branch_Id", defaultValue = "-1") int b_id) {
	    Branch branch = brachService.getBranchById(b_id);
	    List<EventName> eventNames = branch.getEventNames();
	    int id = eventName.getId();
	    System.out.println(b_id);
	    System.out.println("eventeid ;    " + id);
	    System.out.println(eventName.getSport_name());
	    System.out.println(eventName.getCharges());

	    // Clone the original eventName object
	    EventName eventNameClone = new EventName(eventName); // Assuming EventName has a copy constructor
eventNameClone.setCharges(eventName.getCharges());
System.out.println(eventNameClone.getCharges());
	    EventName eventName2 = eventNameService.saveEventName(eventNameClone);
	    System.out.println(eventName2.getSport_name());
System.out.println(eventName2.getCharges());
	    System.out.println("=============================");
	    System.out.println("arraykist");
	    eventNames.add(eventName2);

	    branch.setEventNames(eventNames);
	    System.out.println("setting");
	    Branch branch2 = brachService.updateBranchById(b_id, branch);
	    eventName2.setBranch(branch2);
	    branch2.setEventNames(eventNames);
	    int id1 = eventName2.getId();
	    System.out.println("updating");
	    EventName eventName3 = eventNameService.updateEventNameById(id1, eventName2);
	    ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
	    System.out.println("========================================");
	    // modelAndView.addObject("eventName", new EventName());
	    System.out.println(932);

	    return modelAndView;
	}


	@RequestMapping("/ViewAllBranch")
	public ModelAndView ViewAllBranch() {
		ModelAndView modelAndView = new ModelAndView("BranchViewAll.jsp");
		List<Branch> branchs = brachService.viewAllBranchs();
		modelAndView.addObject("branch", branchs);
		return modelAndView;

	}

	@RequestMapping("/deleteUser")
	public ModelAndView deleteUsertById(@RequestParam(name = "id") int id) {
		boolean b = userService.deleteUserById(id);
		ModelAndView modelAndView = new ModelAndView("ViewAllUser.jsp");

		if (b == true) {
			List<User> users=userService.viewAllUsers();
			modelAndView.addObject("users", users);
		}
		return modelAndView;
	}
	@RequestMapping("/AdminControllerjsp")
	public ModelAndView AdminControllerjsp(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		Admin admin2 = adminService.saveAdmin(admin);
		modelAndView.addObject("saved", admin2.getName() + " saved successfully");
		return modelAndView;
	}
	@RequestMapping("/ViewAllUser")
	public ModelAndView ViewAllUser() {
		ModelAndView modelAndView = new ModelAndView("ViewAllUser.jsp");
		List<User> users=userService.viewAllUsers();
		for (User user : users) {
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getUser_password());
			System.out.println(user.getBranch());
		
			System.out.println(user.getPayment());
			System.out.println(user.getBranch());
			System.out.println(user.getEventNames());
		}
		modelAndView.addObject("user", users);
		return modelAndView;
	}
}