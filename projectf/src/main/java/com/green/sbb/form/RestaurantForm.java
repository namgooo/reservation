package com.green.sbb.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantForm {
		
	@NotEmpty(message="식당선택은 필수항목입니다.")
	private String restaurantName;
	
	@NotEmpty(message="식당주소는 필수항목입니다.")
	private String restaurantAddress;
	
	@NotEmpty(message="식당전화번호는 필수항목입니다.")
	private String restaurantTel;
	
	@NotEmpty(message="식당주인은 필수항목입니다.")
	private String owner;
	
	@NotEmpty(message="사업자등록번호는 필수항목입니다.")
	private String buisnessNumber;
	
	@NotEmpty(message="개업일은 필수항목입니다.")
	private String foundingDay;
	
	private LocalDateTime createDate;
	
}
