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

import com.jakeer.modal.Receptionist;
import com.jakeer.modal.Room;
import com.jakeer.modal.User;
import com.jakeer.services.RecService;
import com.jakeer.services.RoomService;
import com.jakeer.services.UserService;

@ComponentScan({"com.jakeer.services","com.jakeer.repository"})
@Controller
public class ApplicationController {

	@Autowired
	UserService userService;
	@Autowired
	RoomService roomService;
	@Autowired
	RecService recService;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "adminpage";
	}
	@RequestMapping("/adminreg")
	public String adminreg(HttpServletRequest re){
		re.setAttribute("mode", "MODE_ADMINREG");
		return "adminlogin";
	}
	@RequestMapping("/recpreg")
	public String recpreg(HttpServletRequest re){
		re.setAttribute("mode", "MODE_REGISTERS");
		return "adminpage";
	}
	
	@RequestMapping("/roomreg")
	public String roomregistration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_ROOM_REGISTER");
		return "adminpage";
	}
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "adminpage";
	}
	@PostMapping("/save-room")
	public String registerRoom(@ModelAttribute Room user, BindingResult bindingResult, HttpServletRequest request) {
		roomService.saveMyRoom(user);
		request.setAttribute("mode", "MODE_HOME");
		return "adminpage";
	}
	@PostMapping("/save-rec")
	public String registerRec(@ModelAttribute Receptionist user, BindingResult bindingResult, HttpServletRequest request) {
		recService.saveMyReceptionist(user);
		request.setAttribute("mode", "MODE_HOME");
		return "adminpage";
	}

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "adminpage";
	}
	@GetMapping("/show-rooms")
	public String showAllRooms(HttpServletRequest request) {
		request.setAttribute("users", roomService.showAllRooms());
		request.setAttribute("mode", "ALL_ROOMS");
		return "adminpage";
	}
	@GetMapping("/show-recs")
	public String showAllRecs(HttpServletRequest request) {
		request.setAttribute("users", recService.showAllReceptionists());
		request.setAttribute("mode", "ALL_RECS");
		return "adminpage";
	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "adminpage";
	}
	@RequestMapping("/delete-rec")
	public String deleteRec(@RequestParam int id, HttpServletRequest request) {
		recService.deleteMyReceptionist(id);
		request.setAttribute("users", recService.showAllReceptionists());
		request.setAttribute("mode", "ALL_RECS");
		return "adminpage";
	}
	@RequestMapping("/delete-room")
	public String deleteRoom(@RequestParam int id, HttpServletRequest request) {
		roomService.deleteMyRoom(id);
		request.setAttribute("users", roomService.showAllRooms());
		request.setAttribute("mode", "ALL_ROOMS");
		return "adminpage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "adminpage";
	}
	@RequestMapping("/edit-room")
	public String editRoom(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", roomService.editRoom(id));
		request.setAttribute("mode", "MODE_UPDATE_ROOM");
		return "adminpage";
	}
	@RequestMapping("/edit-rec")
	public String editRec(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", recService.editReceptionist(id));
		request.setAttribute("mode", "MODE_UPDATE_REC");
		return "adminpage";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "adminlogin";
	}
	@RequestMapping("/staff")
	public String staff(HttpServletRequest req)
	{
		req.setAttribute("mode", "MODE_STAFF");
		return "staff";
	}
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "adminpage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "adminlogin";
			
		}
	}
	/*@RequestMapping("/recplogin")
	public String recplogin(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_Recp_LOGIN");
		return "recplogin";
	}*/
}
