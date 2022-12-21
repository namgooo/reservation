
package com.green.sbb.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Reservation;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.form.ReservationForm;
import com.green.sbb.repository.ReservationRepository;
import com.green.sbb.repository.RestaurantRepository;
import com.green.sbb.service.CustomerService;
import com.green.sbb.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReservationController {

	private final ReservationService reservationService;
	private final ReservationRepository reservationRepository;
	private final CustomerService customerService;
	private final RestaurantRepository restaurantRepository;
	
	
	@RequestMapping("/reservation/create")
	public String reservation(ReservationForm reservationForm, Model model) {
		
		List<Restaurant> restaurantList = this.restaurantRepository.findAll();
		
		model.addAttribute("restaurantList", restaurantList);
		
		return "reservation_form";
	}
	
    @PostMapping("/reservation/create")
    public String reservationCreate(@Valid ReservationForm reservationForm,
    								BindingResult bindingResult,
    								Principal principal,
    								Model model
    								) {
    	
        if (bindingResult.hasErrors()) {
        	
    		List<Restaurant> restaurantList = this.restaurantRepository.findAll();
    		
    		model.addAttribute("restaurantList", restaurantList);
        	
            return "reservation_form";
        }
        
        Optional<Customer> customer = this.customerService.getCustomer(principal.getName());
  
        this.reservationService.create(reservationForm.getRestaurantName(),
									   reservationForm.getReservationName(),
									   reservationForm.getReservationDay(),
									   reservationForm.getReservationTime(),
									   reservationForm.getPeople(),
									   reservationForm.getComent(),
									   reservationForm.getCreateDate(),
									   customer.get()		                   
        							   );
        
        List<Reservation> reservation = customer.get().getReservation();
        
        Reservation reservationinfo = customer.get().getReservation().get(reservation.size()-1);
        
        model.addAttribute("reservationInfo", reservationinfo);
        
        return "reservation_detail";
        
    }
    
}
