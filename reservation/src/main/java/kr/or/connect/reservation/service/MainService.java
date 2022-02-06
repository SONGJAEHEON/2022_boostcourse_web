package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;

public interface MainService {
	public static final int LIMIT = 4;
	public List<Promotion> getPromotions();
	public List<Category> getCategories();
	public List<Display_info> getDisplay_infos(int cat, int start);
	public int getCount(int cat);
}