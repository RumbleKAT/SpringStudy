package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_CATEGORIES = "Select c.id , c.name, count(p.category_id) as count from category as c join product as p On c.id =p.category_id group by c.id";
	public static final String SELECT_PRODUCTS = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id";
	public static final String SELECT_PRODUCT = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id and p.id = :id";
	public static final String SELECT_PRODUCT_RANGE = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = c.id ORDER BY p.id limit :start, 4";
	public static final String SELECT_PRODUCT_CATEGORY_RANGE = "select p.id,c.id as categoryId,d.id as displayInfoId, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email from product as p, category as c, display_info as d where d.product_id = p.id and p.category_id = :category_id ORDER BY p.id limit :start, 4";
}
