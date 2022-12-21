package com.green.sbb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.sbb.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	// 레스토랑 이름으로 레스토랑 조회
	Optional<Restaurant> findByRestaurantName(String restaurantName);

}
