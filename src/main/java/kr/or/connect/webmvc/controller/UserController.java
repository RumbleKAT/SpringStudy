package kr.or.connect.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	
	@GetMapping(path="/userform")
	public String userform() {
		return "userform";
	}
	
	@PostMapping(path="/regist")
	public String regist(@ModelAttribute User user) {
		//dto를 통해서 한꺼번에 받을 수 있음 
		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 있어야합니다.");
		System.out.println(user);
		return "regist";
	}

}
