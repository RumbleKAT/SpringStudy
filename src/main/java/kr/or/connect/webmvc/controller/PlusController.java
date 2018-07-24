package kr.or.connect.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusform"; //요청이 들어올때 jsp 이름을 알려줌 
	}
	
	@PostMapping(path="/plus")
	public String plus(@RequestParam(name = "value1", required = true)int value1 ,@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
		int result = value1 + value2; //param 값을 value1으로 바꿔줌 
		
		modelMap.addAttribute("value1",value1);
		modelMap.addAttribute("value2",value2);
		modelMap.addAttribute("result",result); //modelMap의 값을 알아서 requestScope에 넣어
	
		return "plusResult";
	}
	
}
