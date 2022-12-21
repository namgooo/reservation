package com.green.sbb.service;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.sbb.DataNotFoundException;
import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.entity.Review;
import com.green.sbb.repository.RestaurantRepository;
import com.green.sbb.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	
	
	// 페이징
	public Page<Review> getList(int page) {
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.reviewRepository.findAll(pageable);
	}
	
	// Integer id로 해당 페이지를 찾는다
	public Review getReview (Integer id) {
		Optional<Review> review = this.reviewRepository.findById(id);
		
		if(review.isPresent()) {
			return review.get();
		}else {
			throw new DataNotFoundException("오류 발생");
		}
	}
	
    public void create(String restaurantName,
    				   String nickName,
    				   String title,
    				   String coment,
    				   String socre,
    				   LocalDateTime createDate,
    				   Customer customer) {
    	
        Review review = new Review();
        
        Restaurant restaurant = this.restaurantRepository.findByRestaurantName(restaurantName).get();
        
        review.setRestaurantName(restaurantName);
        review.setNickName(nickName);
        review.setTitle(title);
        review.setComent(coment);
        review.setScore(socre);
        review.setCreateDate(LocalDateTime.now());
        review.setCustomer(customer);
        review.setRestaurant(restaurant);
        this.reviewRepository.save(review);
        
    }

}
