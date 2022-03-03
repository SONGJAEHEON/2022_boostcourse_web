package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

	@GetMapping(path="/account")
	public String accountPage() {
		return "account";
	}
	
	@GetMapping(path="/logIn")
	public String getLogIn(@RequestParam(name="mail", required=false) String email, HttpSession session) {
		if(email == null)
			return "redirect:account";
		else {
			session.setAttribute("account", email);
			return "redirect:myPage";
		}
	}
	
	@GetMapping(path="/logOut")
	public String getLogOut(HttpSession session) {
		session.removeAttribute("account");
		
		return "redirect:main";
	}
}
