package tn.dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.service.UserNotFoundException;
import tn.dari.service.UserService;

@RestController
@RequestMapping("api/v1/forgotPw")
public class ForgotPasswordController {
	@Autowired 
	UserService userser ; 
	
	@GetMapping(path="/updateToken")
	public void UpdateToken(String token , String email) throws UserNotFoundException{
		 userser.UpdateResetPassword(token, email);
	}

}
