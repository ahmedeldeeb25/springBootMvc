package com.arch.controller;

import java.util.Map;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value={"/" , "/login"})
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "login";
    }
     
    @RequestMapping("/register")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        return "register";
    }

//    @RequestMapping("/403")
//    public String error403() {
//    	System.out.println("Error ........................");
//        return "/error/403";
//    }
    @RequestMapping("/admin")
    public String Admin() {
        return "/admin";
    }
    @RequestMapping("/user")
    public String User() {
        return "/user";
    }
    @RequestMapping("/logout")
    public ModelAndView Logout() {
  	  ModelAndView model = new ModelAndView("login");
		model.addObject("msg", "You've been logged out successfully.");
        return model;
    }
  //for 403 access denied page
  	@RequestMapping(value = "/403", method = RequestMethod.GET)
  	public ModelAndView accesssDenied() {

  		System.out.println("Error ");
  	  ModelAndView model = new ModelAndView();

  	  //check if user is login
  	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  	  if (!(auth instanceof AnonymousAuthenticationToken)) {
  		UserDetails userDetail = (UserDetails) auth.getPrincipal();
  		model.addObject("username", userDetail.getUsername());
  	  }

  	  model.setViewName("/error/403");
  	  return model;

  	}
    

}