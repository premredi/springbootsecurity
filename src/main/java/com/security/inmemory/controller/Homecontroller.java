package com.security.inmemory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
	
	@GetMapping("/home")
	public String showpage() {
		return "home";
	}
	@GetMapping("/welcome")
	public String welcomepage() {
		return "welcome";
	}
	@GetMapping("/admin")
	public String adminpage() {
		return "adminpage";
	}
	@GetMapping("/emp")
	public String employeepage() {
		return "emppage";
	}
	@GetMapping("/std")
	public String studentpage() {
		return "studentpage";
	}
	
	@GetMapping("/denied")
	public String showdenied() {
		return "deniedpage";
	}

}
