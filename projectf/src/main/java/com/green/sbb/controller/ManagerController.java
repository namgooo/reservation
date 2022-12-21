package com.green.sbb.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.form.RestaurantForm;
import com.green.sbb.repository.CustomerRepository;
import com.green.sbb.repository.RestaurantRepository;
import com.green.sbb.service.CustomerService;
import com.green.sbb.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ManagerController {

	private final RestaurantService restaurantService;
	private final RestaurantRepository restaurantRepository;
	private final CustomerService customerService;
	private final CustomerRepository customerRepository;
	
	
	@GetMapping("/manager")
	public String managerPage(Model model) {
		
		List<Customer> customerList = this.customerRepository.findAll();
		
		model.addAttribute("customerList", customerList);
		
		List<Restaurant> restaurantList = this.restaurantRepository.findAll();
		
		model.addAttribute("restaurantList", restaurantList);
		
		return "manager";
	}
		
	
	@RequestMapping("/manager")
	public String manager (Model model, Principal principal) {
		//System.out.println("___________________________________________________________");
		int role = this.customerService.getCustomer(principal.getName()).get().getRole();
			
		if(role == 1) {
			//System.out.println("___________________________________________________________");
			//System.out.println(role);
			return "authority";
			
		} else if(role >= 2) {
			//System.out.println("___________________________________________________________");
			//System.out.println(role);
			return "manager";
			
		}
		
		List<Restaurant> restaurantList = this.restaurantRepository.findAll();
		
		model.addAttribute("restaurantList", restaurantList);
		
		
		return "manager";

	}
	
	
	@GetMapping("manager/create")
	public String managerCreate(RestaurantForm restaurantForm,
								Principal principal,
								Model model) {
			
		return "restaurant_form";
	}
	
	
	@PostMapping("/manager/create")
	public String managerCreate(@Valid RestaurantForm restaurantForm,
							   BindingResult bindingResult,
							   Principal principal,
							   Model model) {
		
		if (bindingResult.hasErrors()) {
			return "restaurant_form";
		}
		
		Optional<Customer> customer = this.customerService.getCustomer(principal.getName());
		
		this.restaurantService.create(restaurantForm.getRestaurantName(),
									  restaurantForm.getRestaurantAddress(),
									  restaurantForm.getRestaurantTel(),
									  restaurantForm.getOwner(),
									  restaurantForm.getBuisnessNumber(),
									  restaurantForm.getFoundingDay(),
									  restaurantForm.getCreateDate(),
									  customer.get()
									  );
		
		return "redirect:/manager";
	}
	
	
//	@RequestMapping("/manager")
//	public String idList (Model model) {
//		
//		List<Customer> customerList = this.customerRepository.findAll();
//		model.addAttribute("customerList", customerList);
//		
//		return "manager";
//	}
	
	@PostMapping("/manager/increase/{id}")
	public String idListIncre (Model model, @PathVariable("id") int id) {
			
		Optional<Customer> c = this.customerService.getCustomers(id);
			
		c.get().setRole(c.get().getRole() + 1);
		
		this.customerRepository.save(c.get());
		
		return "redirect:/manager";
	}
	
	@PostMapping("/manager/decrease/{id}")
	public String idListDecre (Model model, @PathVariable("id") int id) {
		
		Optional<Customer> c = this.customerService.getCustomers(id);
		
		c.get().setRole(c.get().getRole() - 1);
		
		this.customerRepository.save(c.get());
		
		return "redirect:/manager";
	}
	
	@PostMapping("manager/restaurantDel/{id}")
	public String restaurantDel(@PathVariable int id) {
		
		this.restaurantRepository.deleteById(id);
		
		return "redirect:/manager";
	}
	
	
	
	
}
