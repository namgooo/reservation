package com.green.sbb.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreateForm {

    @Size(min = 5, max = 30)
    @NotEmpty(message = "ID 입력은 필수항목입니다.")
    private String customerId;

    @NotEmpty(message = "비밀번호 입력은 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;
    
    @NotEmpty(message = "이름 입력은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "이메일 입력은 필수항목입니다.")
    @Email
    private String email;
    
    @NotEmpty(message = "전화번호 입력은 필수항목입니다.")
    private String tel;
	
}
