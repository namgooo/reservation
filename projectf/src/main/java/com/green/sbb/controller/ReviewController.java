package com.green.sbb.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.entity.Review;
import com.green.sbb.form.ReviewForm;
import com.green.sbb.repository.RestaurantRepository;
import com.green.sbb.repository.ReviewRepository;
import com.green.sbb.service.AnswerService;
import com.green.sbb.service.CustomerService;
import com.green.sbb.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReviewController {

	private final ReviewService reviewService;
	private final AnswerService answerService;
	private final CustomerService customerService;
	private final RestaurantRepository restaurantRepository;
	private final ReviewRepository reviewRepository;
	
	// 리뷰목록
	// defaultValue="0" : 첫번째페이지 번호는 1이 아니고 0임
	@RequestMapping("/review")
	public String review (Model model, @RequestParam(value="page", defaultValue="0") int page) {
		
		Page<Review> paging = this.reviewService.getList(page);
		
		model.addAttribute("paging", paging);
		
		return "review";
	}
	
	// 리뷰상세
	// @PathVariable : 특정 위치 값이 고정되지 않고 달라질 때 사용
    @RequestMapping("/review/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
    	Review review = this.reviewService.getReview(id);
    	model.addAttribute("review", review);
        return "review_detail";
    }
    
    // 리뷰댓글작성
    @PostMapping("/review/create/{id}")
    public String createAnswer(Model model,
    						   @PathVariable("id") Integer id,
    						   @RequestParam String content,
    						   Principal principal) {
    	
    	Review review = this.reviewService.getReview(id);
    	Optional<Customer> customer = this.customerService.getCustomer(principal.getName());
    	
    	this.answerService.create(review, content, customer.get());
    	
    	return String.format("redirect:/review/detail/%s", id);
    }
    
    
    // 리뷰작성(get)
    // 메소드 이름 동일하게 가능 단 매개변수가 다른경우!(메소드 오버로딩)
    // 매개변수에 th:object에 의해 QuestionForm 객체가 필요
    @GetMapping("/review/create")
    public String reviewCreate(ReviewForm reviewForm, Model model) {
    	
		List<Restaurant> restaurantList = this.restaurantRepository.findAll();
		
		model.addAttribute("restaurantList", restaurantList);
    	
    	return "review_form";
    }
    
    // 리뷰작성(post)
    // BindingResult는 검증오류는 보관하는 객체(검증할 객체 바로 다음 위치에 씀)
    // @Valid은 @NotEmpty, @Size 등으로 설정한 검증 기능이 동작
    @PostMapping("/review/create")
    public String reviewCreate(@Valid ReviewForm reviewForm,
    						   BindingResult bindingResult,
    						   Principal principal,
    						   Model model) {
    	
        if (bindingResult.hasErrors()) {
        	
    		List<Restaurant> restaurantList = this.restaurantRepository.findAll();
    		
    		model.addAttribute("restaurantList", restaurantList);
        	
            return "review_form";
        }
        
        Optional<Customer> customer = this.customerService.getCustomer(principal.getName());
  
    	this.reviewService.create(reviewForm.getRestaurantName(),
    							  reviewForm.getNickName(),
    							  reviewForm.getTitle(),
    							  reviewForm.getComent(),
    							  reviewForm.getScore(),
    							  reviewForm.getCreateDate(),
    							  customer.get()
    							  );
    							      							  
        return "redirect:/review";
    }
    
}

