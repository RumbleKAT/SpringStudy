package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ProductImage;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public ProductImage select(Long productId, Long productImageId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("productId", productId);
		parameters.put("productImageId", productImageId);
		return jdbcTemplate.queryForObject(SELECT_PRODUCT_IMAGE,parameters,rowMapper);
	}
	
	public ProductImage select(Long productId,String imageType) {
		Map<String, Object> parameters = new HashMap<String,Object>();
		parameters.put("productId",productId);
		parameters.put("imageType", imageType);
		return jdbcTemplate.queryForObject(SELECT_PRODUCT_IMAGE_TH, parameters, rowMapper);
	}
	
}
