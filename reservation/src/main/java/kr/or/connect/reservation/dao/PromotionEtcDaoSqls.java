package kr.or.connect.reservation.dao;

public class PromotionEtcDaoSqls {
	public static final String GET_ETC = "SELECT display_info.id, file_info.save_file_name FROM display_info, product, product_image, file_info WHERE ?=display_info.id AND display_info.product_id=product.id AND product.id=product_image.product_id AND product_image.type='et' AND product_image.file_id=file_info.id limit 0, 1";
}
