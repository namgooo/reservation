package com.green.sbb.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.green.sbb.entity.Answer;
import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Review;
import com.green.sbb.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public void create(Review review,
					   String content,
					   Customer customer) {
		
	      Answer answer = new Answer();
	      
	      answer.setContent(content);
	      answer.setCreateDate(LocalDateTime.now());
	      answer.setReview(review);
	      answer.setCustomer(customer);
	      this.answerRepository.save(answer);
	}
	
}
