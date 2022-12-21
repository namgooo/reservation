package com.green.sbb;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Reservation;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.entity.Review;
import com.green.sbb.repository.ReservationRepository;
import com.green.sbb.repository.RestaurantRepository;
import com.green.sbb.repository.ReviewRepository;
import com.green.sbb.service.ReviewService;




@SpringBootTest
class ProjectApplicationTests {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Test
	void testJpa() {
		
//		for(int i = 1; i <= 100; i++) {
//					
//			String restaurantName = "맛집"; 
//			String nickName = "박남규";
//			String title = String.format("테스트:[%3d]", i);
//			String coment = "맛집테스트";
//			String score = "5";
//		
//			this.reviewService.create(restaurantName, nickName, title, coment, score);
//		}
	
		Restaurant r1 = new Restaurant();	
		r1.setRestaurantName("쇼오텐");
		r1.setRestaurantAddress("부산 북구 만덕대로40번길 33 1층 쇼오텐");
		r1.setRestaurantTel("0507-1364-0893");
		r1.setOwner("김라멘");
		r1.setBuisnessNumber("1234-5678");
		r1.setFoundingDay("2011-11-11");
		r1.setCreateDate(LocalDateTime.now());
		this.restaurantRepository.save(r1);
		
		Restaurant r2 = new Restaurant();
		r2.setRestaurantName("수우동");
		r2.setRestaurantAddress("제주특별자치도 제주시 한림읍 협재1길 11");
		r2.setRestaurantTel("064-796-5830");
		r2.setOwner("박우동");
		r2.setBuisnessNumber("1234-5678");
		r2.setFoundingDay("2012-12-12");
		r2.setCreateDate(LocalDateTime.now());
		this.restaurantRepository.save(r2);
		
		Restaurant r3 = new Restaurant();
		r3.setRestaurantName("부산명물횟집");
		r3.setRestaurantAddress("부산 중구 자갈치해안로 55");
		r3.setRestaurantTel("0507-1338-7617");
		r3.setOwner("최명물");
		r3.setBuisnessNumber("1234-5678");
		r3.setFoundingDay("2013-10-10");
		r3.setCreateDate(LocalDateTime.now());
		this.restaurantRepository.save(r3);
		
		Restaurant r4 = new Restaurant();
		r4.setRestaurantName("해리단길 경양카츠");
		r4.setRestaurantAddress("부산 해운대구 우동1로 13-29 1층");
		r4.setRestaurantTel("051-894-5620");
		r4.setOwner("김카츠");
		r4.setBuisnessNumber("1234-5678");
		r4.setFoundingDay("2009-5-21");
		r4.setCreateDate(LocalDateTime.now());
		this.restaurantRepository.save(r4);
		
		Restaurant r5 = new Restaurant();	
		r5.setRestaurantName("벵디");
		r5.setRestaurantAddress("제주특별자치도 제주시 구좌읍 해맞이해안로 1108");
		r5.setRestaurantTel("0507-1393-7842");
		r5.setOwner("박문어");
		r5.setBuisnessNumber("1234-5678");
		r5.setFoundingDay("2015-12-9");
		r5.setCreateDate(LocalDateTime.now());	
		this.restaurantRepository.save(r5);
		
		Restaurant r6 = new Restaurant();
		r6.setRestaurantName("진리식당");
		r6.setRestaurantAddress("경남 양산시 물금읍 화산길 10-1 진리식당");
		r6.setRestaurantTel("0507-1440-9113");
		r6.setOwner("이진리");
		r6.setBuisnessNumber("1234-5678");
		r6.setFoundingDay("2012-12-12");
		r6.setCreateDate(LocalDateTime.now());	
		this.restaurantRepository.save(r6);
		
	}
	
	@Test
	void reviewTest() {
		
		Review r1 = new Review();
		r1.setRestaurantName("쇼오텐");
		r1.setNickName("김오이");
		r1.setTitle("맛집임");
		r1.setComent("맛있습니다!");
		r1.setScore("4");
		r1.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r1);
		
		Review r2 = new Review();
		r2.setRestaurantName("쇼오텐");
		r2.setNickName("김오이");
		r2.setTitle("맛집임");
		r2.setComent("맛있습니다!");
		r2.setScore("4");
		r2.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r2);
		
		Review r3 = new Review();
		r3.setRestaurantName("쇼오텐");
		r3.setNickName("김오이");
		r3.setTitle("맛집임");
		r3.setComent("맛있습니다!");
		r3.setScore("4");
		r3.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r3);
		
		Review r4 = new Review();
		r4.setRestaurantName("쇼오텐");
		r4.setNickName("김오이");
		r4.setTitle("맛집임");
		r4.setComent("맛있습니다!");
		r4.setScore("4");
		r4.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r4);
		
		Review r5 = new Review();
		r5.setRestaurantName("쇼오텐");
		r5.setNickName("김오이");
		r5.setTitle("맛집임");
		r5.setComent("맛있습니다!");
		r5.setScore("4");
		r5.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r5);
		
		Review r6 = new Review();
		r6.setRestaurantName("쇼오텐");
		r6.setNickName("김오이");
		r6.setTitle("맛집임");
		r6.setComent("맛있습니다!");
		r6.setScore("4");
		r6.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r6);
		
		Review r7 = new Review();
		r7.setRestaurantName("쇼오텐");
		r7.setNickName("김오이");
		r7.setTitle("맛집임");
		r7.setComent("맛있습니다!");
		r7.setScore("4");
		r7.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r7);
		
		Review r8 = new Review();
		r8.setRestaurantName("쇼오텐");
		r8.setNickName("김오이");
		r8.setTitle("맛집임");
		r8.setComent("맛있습니다!");
		r8.setScore("4");
		r8.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r8);
		
		Review r9 = new Review();
		r9.setRestaurantName("쇼오텐");
		r9.setNickName("김오이");
		r9.setTitle("맛집임");
		r9.setComent("맛있습니다!");
		r9.setScore("4");
		r9.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r9);
		
		Review r10 = new Review();
		r10.setRestaurantName("쇼오텐");
		r10.setNickName("김오이");
		r10.setTitle("맛집임");
		r10.setComent("맛있습니다!");
		r10.setScore("4");
		r10.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r10);
		
		Review r11 = new Review();
		r11.setRestaurantName("쇼오텐");
		r11.setNickName("김오이");
		r11.setTitle("맛집임");
		r11.setComent("맛있습니다!");
		r11.setScore("4");
		r11.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r11);
		
		Review r12 = new Review();
		r12.setRestaurantName("쇼오텐");
		r12.setNickName("김오이");
		r12.setTitle("맛집임");
		r12.setComent("맛있습니다!");
		r12.setScore("4");
		r12.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r2);
		
		Review r13 = new Review();
		r13.setRestaurantName("쇼오텐");
		r13.setNickName("김오이");
		r13.setTitle("맛집임");
		r13.setComent("맛있습니다!");
		r13.setScore("4");
		r13.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r13);
		
		Review r14 = new Review();
		r14.setRestaurantName("쇼오텐");
		r14.setNickName("김오이");
		r14.setTitle("맛집임");
		r14.setComent("맛있습니다!");
		r14.setScore("4");
		r14.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r14);
		
		Review r15 = new Review();
		r15.setRestaurantName("쇼오텐");
		r15.setNickName("김오이");
		r15.setTitle("맛집임");
		r15.setComent("맛있습니다!");
		r15.setScore("4");
		r15.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r5);
		
		Review r16 = new Review();
		r16.setRestaurantName("쇼오텐");
		r16.setNickName("김오이");
		r16.setTitle("맛집임");
		r16.setComent("맛있습니다!");
		r16.setScore("4");
		r16.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r16);
		
		Review r17 = new Review();
		r17.setRestaurantName("쇼오텐");
		r17.setNickName("김오이");
		r17.setTitle("맛집임");
		r17.setComent("맛있습니다!");
		r17.setScore("4");
		r17.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r17);
		
		Review r18 = new Review();
		r18.setRestaurantName("쇼오텐");
		r18.setNickName("김오이");
		r18.setTitle("맛집임");
		r18.setComent("맛있습니다!");
		r18.setScore("4");
		r18.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r18);
		
		Review r19 = new Review();
		r19.setRestaurantName("쇼오텐");
		r19.setNickName("김오이");
		r19.setTitle("맛집임");
		r19.setComent("맛있습니다!");
		r19.setScore("4");
		r19.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r19);
		
		Review r20 = new Review();
		r20.setRestaurantName("쇼오텐");
		r20.setNickName("김오이");
		r20.setTitle("맛집임");
		r20.setComent("맛있습니다!");
		r20.setScore("4");
		r20.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r20);
		
		Review r21 = new Review();
		r21.setRestaurantName("쇼오텐");
		r21.setNickName("김오이");
		r21.setTitle("맛집임");
		r21.setComent("맛있습니다!");
		r21.setScore("4");
		r21.setCreateDate(LocalDateTime.now());
		this.reviewRepository.save(r21);
		
	}

}
