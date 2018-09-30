package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Products;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Products> selectAll();
	public Products select(Long id);
	public List<Products> selectRange(Long startId);
	public List<Products> selectCategoryRange(Long categoryId);
	public int selectCount();
}
