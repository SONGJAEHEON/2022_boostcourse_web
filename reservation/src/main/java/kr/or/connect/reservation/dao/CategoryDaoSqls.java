package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
//	public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
//	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
//	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
	public static final String SELECT_CATs = "SELECT id, name FROM category ORDER BY id ASC";
}
