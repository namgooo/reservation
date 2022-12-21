package com.green.sbb.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RestaurantService {

	private final RestaurantRepository restaurantRepository;
	
	public void create (String restaurantName,
					    String restaurantAddress,
					    String restaurantTel,
					    String owner,
					    String buisnessNumber,
					    String foundingDay,
					    LocalDateTime createDate,
					    Customer customer) {
		
		Restaurant restaurant = new Restaurant();
		
		
		restaurant.setRestaurantName(restaurantName);
		restaurant.setRestaurantAddress(restaurantAddress);
		restaurant.setRestaurantTel(restaurantTel);
		restaurant.setOwner(owner);
		restaurant.setBuisnessNumber(buisnessNumber);
		restaurant.setFoundingDay(foundingDay);
		restaurant.setCreateDate(LocalDateTime.now());
		restaurant.setCustomer(customer);
		
		this.restaurantRepository.save(restaurant);
		
	}
}
