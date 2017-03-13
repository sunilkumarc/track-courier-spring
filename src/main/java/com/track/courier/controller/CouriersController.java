package com.track.courier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.track.courier.dao.CouriersDAO;
import com.track.courier.model.Courier;
import com.track.courier.model.User;

@Controller
public class CouriersController {

	@Autowired
	private CouriersDAO couriersDAO;

	@PostMapping("/courier/add")
	public ModelAndView addCourier(@Validated @RequestBody Courier courier, Model model) {
		Courier storedCourier = couriersDAO.addCourier(courier);

		ModelAndView dashboardView = new ModelAndView("dashboard");
		dashboardView.addObject("User", new User());
		return dashboardView;
	}

	@GetMapping("/couriers")
	public Courier getSingleCourier() {
		Courier courier = couriersDAO.getSingleCourier("123");
		System.out.println(courier.getColor());
		return courier;
	}
}
