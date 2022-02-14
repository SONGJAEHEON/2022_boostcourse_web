package kr.or.connect.reservation.dao;

public class DetailDaoSqls {
	public static final String GET_DETAILs = "SELECT display_info.id, file_info.save_file_name, product.description, product.content, AVG(score) AS average, COUNT(comment) AS count FROM product, display_info, product_image, file_info, reservation_user_comment WHERE display_info.id=? AND product.id=display_info.product_id AND product.id=product_image.product_id AND product_image.file_id=file_info.id AND product_image.type='ma'";
}
