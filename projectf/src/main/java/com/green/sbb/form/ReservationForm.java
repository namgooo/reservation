package com.green.sbb.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationForm {

	@NotEmpty(message="식당선택은 필수항목입니다.")
	private String restaurantName;
	
	@NotEmpty(message="예약자는 필수항목입니다.")
	@Size(max=100)
	private String reservationName;
	
	@NotEmpty(message="예약날짜는 필수항목입니다.")
	private String reservationDay;
	
	@NotEmpty(message="예약시간은 필수항목입니다.")
	private String reservationTime;
	
	@NotEmpty(message="인원수는 필수항목입니다.")
	private String people;
	
	private String coment;
	
	private LocalDateTime createDate;
	
}
