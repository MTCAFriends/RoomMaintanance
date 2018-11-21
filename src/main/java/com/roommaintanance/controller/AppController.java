package com.roommaintanance.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.roommaintanance.service.UserDeatilsService;

@Controller
public class AppController {
	@Autowired
	private UserDeatilsService userDeatilsService;
	
	
@RequestMapping(value = { "/" }, method = RequestMethod.GET)
public String mainLofinPage() {
	return "fileUploadForm";
}
@RequestMapping(value = "/home", method = RequestMethod.GET)
public String homePage() {
    return "home-page";
}
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public String adminPage(ModelMap model) {
	model.addAttribute("user", getPrincipal());
	return "home-page";
}
@RequestMapping(value = "/login", method = RequestMethod.GET)
public String loginPage() {
    return "login";
}
@RequestMapping(value="/logout", method = RequestMethod.GET)
   public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      if (auth != null){    
         new SecurityContextLogoutHandler().logout(request, response, auth);
      }
      return "login";
   }

@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
public String accessDeniedPage(ModelMap model) {
	model.addAttribute("user", getPrincipal());
	return "accessDenied";
}

private String getPrincipal(){
	String userName = null;
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	if (principal instanceof UserDetails) {
		userName = ((UserDetails)principal).getUsername();
	} else {
		userName = principal.toString();
	}
	return userName;
}}
