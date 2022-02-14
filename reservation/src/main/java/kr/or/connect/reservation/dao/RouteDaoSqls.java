package kr.or.connect.reservation.dao;

public class RouteDaoSqls {
	public static final String GET_ROUTE = "SELECT save_file_name, place_street, place_lot, place_name, tel FROM display_info, display_info_image, file_info WHERE display_info.id=? AND display_info.id=display_info_id AND file_info.id=display_info_image.file_id;";
}
