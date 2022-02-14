package kr.or.connect.reservation.service.impl;

import java.util.List;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.Detail;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import kr.or.connect.reservation.dao.DetailDao;
import kr.or.connect.reservation.dao.Detail_DiscountInfoDao;
import kr.or.connect.reservation.service.DetailService;
import static kr.or.connect.reservation.service.DetailService.LIMIT;
import kr.or.connect.reservation.dto.Route;
import kr.or.connect.reservation.dao.RouteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetailServiceImpl implements DetailService {
	@Autowired
	DetailDao detailDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	Detail_DiscountInfoDao detail_DiscountInfoDao;
	
	@Autowired
	RouteDao routeDao;
	
	@Override
	@Transactional
	public Detail getDetail(int id) {
		Detail obj = detailDao.getDetails(id);
		return obj;
	}

	@Override
	@Transactional
	public List<Comment> getComments(int id, int cnt) {
		List<Comment> list;
		if(cnt==1)
			list = commentDao.getComments(id, LIMIT);
		else
			list = commentDao.getComments(id, 0);

		return list;
	}

	@Override
	@Transactional
	public List<Detail_DiscountInfo> getDetial_DiscountInfos(int id) {
		List<Detail_DiscountInfo> list = detail_DiscountInfoDao.getDiscountInfos(id);
		
		return list;
	}

	@Override
	@Transactional
	public Route getRoute(int id) {
		return routeDao.getRoute(id);
	}
}
