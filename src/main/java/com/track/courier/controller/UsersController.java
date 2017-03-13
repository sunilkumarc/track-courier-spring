package com.track.courier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.track.courier.dao.CouriersDAO;
import com.track.courier.dao.UsersDAO;
import com.track.courier.model.Courier;
import com.track.courier.model.User;

@Controller
public class UsersController {

	@Autowired
	private UsersDAO usersDAO;

	@Autowired
	private CouriersDAO couriersDAO;

	@GetMapping("/")
	public String homePage(Model model) {

		model.addAttribute("name", "Sunil");
		return "index";
	}

	@GetMapping("/users/register")
	public ModelAndView registerPage(Model model) {

		return new ModelAndView("register");
	}

	@PostMapping("/users/dashboard")
	public ModelAndView registerUser(@ModelAttribute User user) {

		User registeredUser = usersDAO.registerUser(user);
		ModelAndView dashboardView = new ModelAndView("dashboard");
		dashboardView.addObject("User", registeredUser);

		List<Courier> couriers = couriersDAO.findAll();
		dashboardView.addObject("Couriers", couriers);
		

		return dashboardView;
	}
}
