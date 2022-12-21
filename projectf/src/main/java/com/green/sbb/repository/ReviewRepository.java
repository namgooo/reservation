package com.green.sbb.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.sbb.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	Page<Review> findAll(Pageable pageable);
}
