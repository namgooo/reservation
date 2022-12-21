package com.green.sbb.controller;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.green.sbb.form.UserCreateForm;
import com.green.sbb.service.CustomerService;
import com.green.sbb.service.UserSecurityService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final CustomerService customerService;
	private final UserSecurityService userSecurityService;
	
	//회원가입
	
	@GetMapping("/user/signup")
	public String signup (UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
    @PostMapping("/user/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        
        try {
        	
            customerService.create(userCreateForm.getCustomerId(),
					   userCreateForm.getPassword1(),
					   userCreateForm.getName(),
					   userCreateForm.getEmail(),
					   userCreateForm.getTel());

        } catch (DataIntegrityViolationException e) {
        	
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            
            return "signup_form";
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            
            return "signup_form";
        }
        
        return "redirect:/";
    }
    
    // 로그인/로그아웃
    
    @GetMapping("/user/login")
    public String login() {
        return "login_form";
    }
    
    
    
    
	
}
