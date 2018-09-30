package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.ProductImage;

public interface ProductImageService {
	public ProductImage select(Long productId, Long productImageId);
	public ProductImage select_TH(Long productId,String imageType);
}
