package com.green.sbb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.sbb.entity.Reservation;
import com.green.sbb.repository.ReservationRepository;
import com.green.sbb.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	@RequestMapping("/")
	public String root() {
		return "redirect:main";
	}
	
	@RequestMapping("/main")
	public String main(Model model) {
		
		model.addAttribute("Hello", "님 환영합니다.");
		
		return "main";
	}
	
	@RequestMapping("/restaurant1")
	public String restaurant1() {
		return "restaurant1";
	}
	
	@RequestMapping("/restaurant2")
	public String restaurant2() {
		return "restaurant2";
	}
	
	@RequestMapping("/restaurant3")
	public String restaurant3() {
		return "restaurant3";
	}
	
	@RequestMapping("/restaurant4")
	public String restaurant4() {
		return "restaurant4";
	}
	
	@RequestMapping("/restaurant5")
	public String restaurant5() {
		return "restaurant5";
	}
	
	@RequestMapping("/restaurant6")
	public String restaurant6() {
		return "restaurant6";
	}
	
	
	
}
