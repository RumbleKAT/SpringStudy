package kr.or.connect.reservation.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Category;


public class CategoryDaoTest {
	
	public static void main(String [] args) {
		ApplicationContext aContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CategoryDao categoryDao = aContext.getBean(CategoryDao.class);
		List<Category> arr = categoryDao.selectAll();
		
		for(Category category : arr) {
			System.out.println(category.toString());
		}
	}
}
