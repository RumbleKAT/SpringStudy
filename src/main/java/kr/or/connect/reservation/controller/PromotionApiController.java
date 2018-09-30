package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/promotions")
public class PromotionApiController {
	
	@Autowired
	PromotionService promotionService;
	
	@GetMapping
	public Map<String, Object> selectAll(){
		List<Promotion> promotions = promotionService.selectAll();
	
		Map<String,Object> map = new HashMap<>();
		map.put("items", promotions);
		map.put("size", promotions.size());
		return map;
	}
}
