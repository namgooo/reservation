package com.green.sbb.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewForm {
	
	@NotEmpty(message="식당이름은 필수항목입니다.")
	@Size(max=50)
	private String restaurantName;
	
	@NotEmpty(message="작성자(닉네임)는 필수항목입니다.")
	@Size(max=50)
	private String nickName;
	
	@NotEmpty(message="제목은 필수항목입니다.")
	@Size(max=100)
	private String title;
	
	@NotEmpty(message="내용은 필수항목입니다.")
	private String coment;
	
	@NotEmpty(message="평점은 필수항목입니다.")
	private String score;
	
	private LocalDateTime createDate;
	
}
