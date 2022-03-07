package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT = "SELECT display_info.id, description, opening_hours, place_street, place_lot, price, COUNT(reservation_info.id) AS cnt, save_file_name FROM product, product_image, file_info, product_price, display_info LEFT OUTER JOIN reservation_info ON display_info.id=reservation_info.display_info_id WHERE :id=display_info.id AND display_info.product_id=product.id AND product.id=product_image.product_id AND product_image.file_id=file_info.id AND product_image.type='ma' AND product.id=product_price.product_id ORDER BY product_price.price ASC";
}
