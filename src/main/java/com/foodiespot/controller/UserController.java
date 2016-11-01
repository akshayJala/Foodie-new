package com.foodiespot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodiespot.dao.UserDetailsDao;
import com.foodiespot.model.UserDetails;
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserDetails userDetails ;
	
	@Autowired
	UserDetailsDao userDetailsDao ;

	@ModelAttribute("userDetails")
	public UserDetails newUserDetails(){
		return new UserDetails() ;
	}
	
    /*---------------------------------------------------*/
	

	@RequestMapping(value = "/addUser")
	public String goToRegisterPage(Model model) {
		model.addAttribute("userDetails", new UserDetails());
		return "Register";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView ForAddingUser(@ModelAttribute("userDetails") UserDetails userDetails, BindingResult result) {
		logger.info("ForAddingUser method of RegisterController begins here with password " + userDetails.getPassword());
		
		
		
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("addUser");
			
			return modelAndView;
		} else {
			userDetailsDao.saveUserDetails(userDetails);
			ModelAndView modelAndView = new ModelAndView("redirect:/index");
			modelAndView.addObject("registerMessage", "You are Logged In Successfully.");
			
			logger.info("ForAddingUser method of RegisterController ends here with name " + userDetails.getFullName());
			return modelAndView;
		}
		
	}

}
