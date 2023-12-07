package com.am.loginpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String viewHomepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String signUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_signup")
	public String processSignup(User user) {
		userRepository.save(user);
		return "signup_success";
	}

}
