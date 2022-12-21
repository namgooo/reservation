package com.green.sbb.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Reservation;
import com.green.sbb.entity.Review;
import com.green.sbb.repository.CustomerRepository;
import com.green.sbb.repository.ReservationRepository;
import com.green.sbb.repository.ReviewRepository;
import com.green.sbb.service.CustomerService;
import com.green.sbb.service.MyPageService;
import com.green.sbb.service.ReservationService;
import com.green.sbb.service.RestaurantService;
import com.green.sbb.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageController {
	
	private final RestaurantService restaurantService;
	private final ReservationService reservationService;
	private final ReviewService reviewService;
	private final CustomerService customerService;
	private final ReservationRepository reservationRepository;
	private final MyPageService myPageService;
	private final ReviewRepository reviewRepositoty;
	private final CustomerRepository customerRepository;
	
	@RequestMapping("/mypage")
	public String mypage(Model model, Principal principal, @RequestParam(value="page", defaultValue="0") int page) {
		
		// 리뷰 페이징
        Page<Review> paging = this.reviewService.getList(page);
        model.addAttribute("paging", paging);
		
		Optional<Customer> customer = this.customerService.getCustomer(principal.getName());
		
		List<Reservation> reservationList = customer.get().getReservation();	
		model.addAttribute("reservationList", reservationList);
		
		List<Review> reviewList = customer.get().getReview();
		model.addAttribute("reviewList", reviewList);
		
		List<Customer> customerRole = this.customerRepository.findAll();
		customer.get().getRole();
		model.addAttribute("customerRole", customer.get().getRole());
		
		return "mypage";
	}
	
	@PostMapping("/mypage/reservationDel/{id}")
	public String reservationDel(@PathVariable int id) {
		
		this.reservationRepository.deleteById(id);
		
		return "redirect:/mypage";
	}
	
	@PostMapping("/mypage/reviewDel/{id}")
	public String reviewDel(@PathVariable int id) {
		
		this.reviewRepositoty.deleteById(id);
		
		return "redirect:/mypage";
	}

}
