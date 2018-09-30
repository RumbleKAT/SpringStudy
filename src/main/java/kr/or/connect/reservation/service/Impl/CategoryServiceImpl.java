package kr.or.connect.reservation.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dto.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
		
	@Override
	@Transactional 
	public List<Category> getCategory() {
		List<Category> categories = categoryDao.selectAll();
		return categories;
	}
	
}
