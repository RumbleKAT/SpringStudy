package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Products;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path="/products")
public class ProductsApiController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	public Map<String, Object> select(@PathVariable(name="id")Long id){
		Products product = productService.select(id);
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		return map;
	}
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false) Long start,
		@RequestParam(name="categoryId", required=false) Long categoryId){		
		
		List<Products> total_products;
		List<Products>products = new ArrayList<Products>();
		int totalCount = 0;
		int pageCount = 0;
		int index = 0;
		int length = 0;
		
		if(categoryId != null) {
			total_products = productService.selectCategoryRange(categoryId);
			totalCount = total_products.size();
			index = start.intValue();
			
			if(totalCount - index < 4) {
				length = totalCount - index;
			}else {
				length = ProductService.LIMIT;	
			}
			
			for(int i = 0;i < length; i++) {
				products.add(total_products.get(index + i));
				pageCount++;
			}
		}else {
			total_products = productService.selectAll();
			totalCount = total_products.size();
			
			if(start != null) {
				index = start.intValue();
				
				if(totalCount - index < 4) {
					length = totalCount - index;
				}else {
					length = ProductService.LIMIT;	
				}
			
			}else {
				index = 0;
				length = totalCount;
			}
			
			for(int i = 0;i < length; i++) {
				products.add(total_products.get(index + i));
				pageCount++;
			}
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("productsCount", pageCount);
		map.put("products",products);
				
		return map;
	}

}
