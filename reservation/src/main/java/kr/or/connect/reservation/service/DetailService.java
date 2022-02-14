package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Detail;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.Route;


public interface DetailService {
	public static final int LIMIT = 3;
	public Detail getDetail(int id);
	public List<Detail_DiscountInfo> getDetial_DiscountInfos(int id);
	public List<Comment> getComments(int id, int cnt);
	public Route getRoute(int id);
}
