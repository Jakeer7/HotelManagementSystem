package com.jakeer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jakeer.modal.Customer;
import com.jakeer.modal.Receptionist;
import com.jakeer.services.CustService;
import com.jakeer.services.RecService;
@ComponentScan({"com.jakeer.services","com.jakeer.repository"})
@Controller
public class ReceptionistController {

	@Autowired
	CustService userService;
	@Autowired
	RecService recService;
	

	@RequestMapping("/welcomes")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/registers")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "recppage";
	}

	@PostMapping("/save-users")
	public String registerCustomer(@ModelAttribute Customer user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyCustomer(user);
		request.setAttribute("mode", "MODE_HOME");
		return "recppage";
	}

	@GetMapping("/show-userss")
	public String showAllCustomers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllCustomers());
		request.setAttribute("mode", "ALL_USERS");
		return "recppage";
	}

	@RequestMapping("/delete-users")
	public String deleteCustomer(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyCustomer(id);
		request.setAttribute("users", userService.showAllCustomers());
		request.setAttribute("mode", "ALL_USERS");
		return "recppage";
	}
	
	@RequestMapping("/edit-users")
	public String editCustomer(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editCustomer(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "recppage";
	}
	
	@RequestMapping("/logins")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "adminpage";
	}
	
	@RequestMapping ("/login-users")
	public String loginCustomer(@ModelAttribute Receptionist user, HttpServletRequest request) {
		if(recService.findByReceptionistnameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "recppage";
		}
		else {
			request.setAttribute("error", "Invalid Receptionistname or Password");
			request.setAttribute("mode", "MODE_Recp_LOGIN");
			return "recplogin";
			
		}
	}
	@RequestMapping("/recplogins")
	public String recplogin(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_Recp_LOGIN");
		return "recplogin";
	}
}
