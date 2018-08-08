package kr.or.connect.reservation.dao;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.Product;
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
	 
	 public Products select(Integer id) {
		 Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id", id);
		 return jdbc.queryForObject(SELECT_PRODUCT, parameters, rowMapper);
	 }
}