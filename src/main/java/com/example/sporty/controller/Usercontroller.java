package com.example.sporty.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.sporty.domain.Shoes;
import com.example.sporty.domain.User;
import com.example.sporty.service.ShoesService;
import com.example.sporty.service.Userservice;

@Controller
public class Usercontroller {

	
	@Autowired
	private Userservice userservice;
	
	 @Autowired
	    private ShoesService service;
	@RequestMapping("/")
	public String home() {
		
		return "Home";
	}
	
	@GetMapping("/register")
	public String saveUser(Model model) {
		
		model.addAttribute("users", new User());
		return "Signup";
	}
	
	@RequestMapping(value="/saveuser",method = RequestMethod.POST )
	public String signup(Model model, User users) {
        List<Shoes> listproducts = service.listAll();
        model.addAttribute("listproducts", listproducts);
        System.out.print("Get / ");	
		userservice.save(users);
		return "index";
	}
	@GetMapping("/login")
	public String login()
	{
		
		return "Signin";
	}
	
	@PostMapping("/signin")
	public String login(@ModelAttribute("user")User user,Model model)
	{
		
		User oauthUser = userservice.login(user.getEmail(),user.getPassword());
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser))
		{        List<Shoes> listproducts = service.listAll();
		model.addAttribute("listproducts", listproducts);
			model.addAttribute("msg", "You have Succesfully Logged in");
			return "index";
			
			
		} else {
			model.addAttribute("msg", "Invalid Username or Password");
			return "Signin";
		}
		
	}
	
	
}
