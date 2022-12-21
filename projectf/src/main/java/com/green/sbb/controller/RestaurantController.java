package com.green.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantController {
	
	@RequestMapping("/restaurantOne")
	public String restaurantOne() {
		return "restaurant_one";
	}
	
	
	
}
	