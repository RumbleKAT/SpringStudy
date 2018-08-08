package kr.or.connect.reservation.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Products;

public class ProductDaoTest {
	
	public static void main(String [] args) {
		ApplicationContext aContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ProductDao productDao = aContext.getBean(ProductDao.class);
		
		System.out.println(productDao.select(3));
		
	}
}
