package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_CATEGORIES = "Select c.id , c.name, count(p.category_id) as count from category as c, product as p, display_info as d where c.id =p.category_id and d.product_id = p.id group by c.id";
	public static final String SELECT_PRODUCTS = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id";
	public static final String SELECT_PRODUCT = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id and p.id = :id";
	public static final String SELECT_PRODUCT_RANGE = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, p.create_date, p.modify_date from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id ORDER BY p.id DESC limit :start, :limit";
	
	public static final String SELECT_PRODUCT_CATEGORY_RANGE = "select p.id, c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id and c.id = :category_id ORDER BY p.id";
	public static final String SELECT_PRODUCT_COUNT = "SELECT count(*) FROM product";
	public static final String SELECT_PRODUCT_CATEGORY_COUNT = "SELECT count(*) FROM product where categoryId = :categoryId";	
	
	public static final String SELECT_PROMOTIONS = "select Distinct pm.id , p.id as productId , c.id as categoryId, c.name as categoryName, p.description, pi.id as productImageId from product as p, promotion as pm, product_image as pi, category as c Where c.id = p.category_id and p.id = pi.product_id and pm.product_id = p.id and pi.type = 'ma' order by pm.id";
	public static final String SELECT_PRODUCT_IMAGE = "select fi.save_file_name From product as p, product_image as pi , file_info as fi where p.id = pi.product_id and pi.file_id = fi.id and  p.id = :productId and pi.id = :productImageId";
	public static final String SELECT_PRODUCT_IMAGE_TH = "select fi.save_file_name From product as p, product_image as pi , file_info as fi where p.id = pi.product_id and pi.file_id = fi.id and  p.id = :productId and pi.type = :imageType";
}