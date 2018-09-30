package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.ProductImageService;

@RestController
@RequestMapping(path="/productImages")
public class ProductImageApiController {
	
	@Autowired
	ProductImageService productImageService;
	
	@Autowired
    private ServletContext servletContext;
	
	@GetMapping("/{productId}/{productImageId}")
	public Map<String, Object> select(@PathVariable(name="productId",required=true)Long productId,
			@PathVariable(name="productImageId",required=true) Long productImageId){
	
		ProductImage productImage = productImageService.select(productId, productImageId);
		String img_url = servletContext.getContextPath() + "/" + productImage.getSave_file_name();
		Map<String,Object> map = new HashMap<>();
		map.put("src",img_url);
		
		return map;
	}
	
	@GetMapping("/{productId}")
	public Map<String, Object> select_Th(@PathVariable(name="productId",required=true)Long productId,
		@RequestParam(name="type",required=true) String imageType){
		
		ProductImage productImage = productImageService.select_TH(productId, imageType);
		String img_url = servletContext.getContextPath() + "/" + productImage.getSave_file_name();
		
		Map<String,Object> map = new HashMap<>();
		map.put("src",img_url);
				
		return map;
	}
	

}
