package com.track.courier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

	@GetMapping("/users/login")
	public ModelAndView loginPage(Model model) {

		String user_not_exists = (String) model.asMap().get("user_not_exists");
		ModelAndView loginView = new ModelAndView("login");

		if (user_not_exists != null) {
			loginView.addObject("user_not_exists", user_not_exists);
		}

		return loginView;
	}

	@PostMapping("/users/login")
	public ModelAndView loginAndRedirect(@ModelAttribute User user, RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView(new RedirectView("dashboard"));
		User exisingUser = usersDAO.findUser(user.getUsername(), user.getPassword());
		redirectAttributes.addFlashAttribute("user", exisingUser);

		List<Courier> couriers = couriersDAO.findAll();
		redirectAttributes.addFlashAttribute("couriers", couriers);
		return model;
	}

	@PostMapping("/users/dashboard")
	public ModelAndView registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {

		User registeredUser = usersDAO.registerUser(user);
		List<Courier> couriers = couriersDAO.findAll();

		ModelAndView model = new ModelAndView(new RedirectView("dashboard"));
		redirectAttributes.addFlashAttribute("user", registeredUser);
		redirectAttributes.addFlashAttribute("couriers", couriers);

		return model;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/users/dashboard")
	public ModelAndView dashboardPage(Model model, RedirectAttributes redirectAttributes) {

		User user = (User) model.asMap().get("user");
		List<Courier> couriers = (List<Courier>) model.asMap().get("couriers");

		if (user == null) {
			ModelAndView loginView = new ModelAndView(new RedirectView("login"));
			redirectAttributes.addFlashAttribute("user_not_exists", "User doesn't exists dude");
			return loginView;
		}

		ModelAndView dashboardView = new ModelAndView("dashboard");
		dashboardView.addObject("User", user);
		dashboardView.addObject("Couriers", couriers);

		return dashboardView;
	}
}
