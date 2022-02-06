package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTIONs = "SELECT promotion.id, file_info.save_file_name FROM promotion, product, product_image, file_info WHERE promotion.product_id=product.id AND product.id=product_image.product_id AND product_image.type='th' AND product_image.file_id=file_info.id ORDER BY promotion.id ASC";
}
