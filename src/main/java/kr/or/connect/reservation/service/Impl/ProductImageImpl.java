package kr.or.connect.reservation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.ProductImageService;

@Service
public class ProductImageImpl implements ProductImageService{
	
	@Autowired
	ProductImageDao productImageDao;

	@Override
	@Transactional
	public ProductImage select(Long productId, Long productImageId) {
		ProductImage productImage = productImageDao.select(productId, productImageId);
		return productImage;
	}

	@Override
	@Transactional
	public ProductImage select_TH(Long productId,String imageType) {
		ProductImage productImage = productImageDao.select(productId,imageType);
		return productImage;
	}
	
}
