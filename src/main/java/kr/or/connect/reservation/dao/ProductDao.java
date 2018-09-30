package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Products;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ProductDao {
	 private NamedParameterJdbcTemplate jdbc;
	 private RowMapper<Products> rowMapper = BeanPropertyRowMapper.newInstance(Products.class);
	 
	 public ProductDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	 }
	 
	 public List<Products> selectAll(){
		return jdbc.query(SELECT_PRODUCTS, rowMapper);
	 }
	 
	 public Products select(Long id) {
		 Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id", id);
		 return jdbc.queryForObject(SELECT_PRODUCT, parameters, rowMapper);
	 }
	 
	 public List<Products> selectRange(Long startId, Integer limit){
		 Map<String, Object> parameters = new HashMap<String,Object>();
		 parameters.put("start", startId);
		 parameters.put("limit", limit);
		 return jdbc.query(SELECT_PRODUCT_RANGE, parameters,rowMapper);
	 }
	 
	 public List<Products> selectCategoryRange(Long categoryId){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("category_id", categoryId);
		return jdbc.query(SELECT_PRODUCT_CATEGORY_RANGE, parameters,rowMapper);
	 }
	 
	 public int selectCount() {
		return jdbc.queryForObject(SELECT_PRODUCT_COUNT, Collections.emptyMap(), Integer.class);
	 }
	 
	 public int selectCategoryCount(Long categoryId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("category_id", categoryId);
		return jdbc.queryForObject(SELECT_PRODUCT_CATEGORY_COUNT, parameters, Integer.class);
	 }
		
}