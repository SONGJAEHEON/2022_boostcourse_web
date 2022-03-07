package kr.or.connect.reservation.dao;

public class PriceDaoSqls {
	public static final String GET_PRICE_INFOs = "SELECT price_type_name, discount_rate, price FROM display_info, product, product_price WHERE display_info.id=:id AND display_info.product_id=product.id AND product.id=product_price.product_id";
}