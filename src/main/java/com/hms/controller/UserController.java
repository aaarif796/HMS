package com.hms.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.entity.*;
import com.hms.service.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService srv;

	@GetMapping("/")
	public String home() {
		System.out.println("Index");
		return "index";
	}
	@GetMapping("/about")
	public String About() {
		System.out.println("Enter inside about section");
		return "about";
	}
	@GetMapping("/service")
	public String Service() {
		System.out.println("Enter into service section");
		return "service";
	}
	@GetMapping("/signin")
	public String singin(){
		System.out.println("Enter to signin section");
		return "signin";
	}
	@GetMapping("/contact")
	public String contact() {
		System.out.println("Enter into contact section");
		return "contact";
	}

	@GetMapping("appointment")
	public String appointment() {
		System.out.println("Enter into appointment section");
		return "appointment";
	}

	@GetMapping("feature")
	public String feature() {
		System.out.println("Enter into feature section");
		return "feature";
	}

	@GetMapping("team")
	public String team() {
		System.out.println("Enter into team section");
		return "team";
	}

	@GetMapping("testimonial")
	public String testimonial() {
		System.out.println("Enter into testimonial section");
		return "testimonial";
	}

	@GetMapping("404")
	public String Error404() {
		System.out.println("Enter into Error404 section");
		return "404";
	}
	@GetMapping("createaccount")
	public String createAccount() {
		System.out.println("Enter into CreateAccount section");
		return "createaccount";
	}
	@PostMapping("createuser")
	public String createuser(@ModelAttribute User u,HttpSession session) {
		System.out.println(u);
		srv.addUser(u);
		session.setAttribute("msg","New Staff added sucessfully");
		return "redirect:/signin";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
    	System.out.println("Enter into dashboard section");
    	return "dashboard";
	}

	@PostMapping("/signin")
    public String signin(@RequestParam("userName") String userName,@RequestParam("password") String password, HttpSession session) {
		if (!userName.isEmpty() && !password.isEmpty()) {
			User user = srv.findByUserName(userName);
			if (user != null && user.getPassword().equals(password)) {
				session.setAttribute("username", userName);
				return "redirect:/dashboard";
			} 
			else {
				session.setAttribute("error", "Invalid username or password");
				return "redirect:/signin";
			}
		} 
		else {
			session.setAttribute("error", "Invalid username or password");
			return "redirect:/signin";
		}
    }
	
}
