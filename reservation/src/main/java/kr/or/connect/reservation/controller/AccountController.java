package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

	@GetMapping(path="/logIn")
	public String getLogIn(@RequestParam(value="email", required=true) String email) {
		
		
		return "myPage";
	}
	
	@GetMapping(path="/logOut")
	public String getLogOut(@RequestParam(value="email", required=false) String email) {
		
		
		return "main";
	}
}
