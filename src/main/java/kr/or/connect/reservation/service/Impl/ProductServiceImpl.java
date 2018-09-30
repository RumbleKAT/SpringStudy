package kr.or.connect.reservation.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Products;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	@Override
	@Transactional
	public List<Products> selectAll() {
		List<Products> products = productDao.selectAll();
		return products;
	}

	@Override
	@Transactional
	public Products select(Long id) {
		Products product = productDao.select(id);
		return product;
	}

	@Override
	@Transactional
	public List<Products> selectRange(Long startId) {
		List<Products> products = productDao.selectRange(startId, ProductService.LIMIT);
		return products;
	}

	@Override
	@Transactional
	public List<Products> selectCategoryRange(Long categoryId) {
		List<Products> products = productDao.selectCategoryRange(categoryId);
		return products;
	}

	@Override
	@Transactional
	public int selectCount() {
		return productDao.selectCount();
	}

}
