package kr.or.connect.reservation.dao;

public class Display_infoDaoSqls {
	public static final String SELECT_ALL = "SELECT product.id, product.description, product.content, display_info.place_name, file_info.save_file_name FROM product, display_info, product_image, file_info WHERE product.id=display_info.product_id AND product.id=product_image.product_id AND product_image.type='th' AND product_image.file_id=file_info.id ORDER BY product.id ASC limit :start, :limit";
	public static final String SELECT_SPECIFIC = "SELECT product.id, product.description, product.content, display_info.place_name, file_info.save_file_name FROM category, product, display_info, product_image, file_info WHERE :cat=category.id AND category.id=product.category_id AND product.id=display_info.product_id AND product.id=product_image.product_id AND product_image.type='th' AND product_image.file_id=file_info.id ORDER BY product.id ASC limit :start, :limit";
	public static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product, display_info WHERE product.id=display_info.product_id";
	public static final String SELECT_COUNT_BY_ID = "SELECT count(*) FROM category, product, display_info WHERE category.id=product.category_id AND product.id=display_info.product_id AND category.id=:id";
}
