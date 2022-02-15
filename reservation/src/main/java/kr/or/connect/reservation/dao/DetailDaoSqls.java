package kr.or.connect.reservation.dao;

public class DetailDaoSqls {
	public static final String GET_DETAILs = "SELECT display_info.id, file_info.save_file_name, product.description, product.content, ROUND(AVG(score), 1) AS average, COUNT(comment) AS count FROM product, product_image, file_info, display_info LEFT OUTER JOIN reservation_info ON display_info.id=reservation_info.display_info_id LEFT OUTER JOIN reservation_user_comment ON reservation_info.id=reservation_user_comment.reservation_info_id WHERE display_info.id=? AND product.id=display_info.product_id AND product.id=product_image.product_id AND product_image.file_id=file_info.id AND product_image.type='ma'";
}
