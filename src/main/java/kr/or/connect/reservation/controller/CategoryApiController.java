package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.dto.Category;

@RestController
public class CategoryApiController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(path="/categories",method=RequestMethod.GET)
	public Map<String, Object> getCategoryList(){
		List<Category> categories = categoryService.getCategory();

		Map<String, Object> map = new HashMap<>();
		map.put("items", categories);
		map.put("size", categories.size());

		return map;
	}
}
