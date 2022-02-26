package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.Detail_DiscountInfoDao;
import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	Detail_DiscountInfoDao detail_DiscountInfoDao;
	
	@Override
	@Transactional
	public Reservation getReservationInfo(int id) {
		Reservation rv = reservationDao.select(id);
		return rv;
	}

	@Override
	@Transactional
	public List<Detail_DiscountInfo> getRservationInfo_DiscountInfo(int id) {
		List<Detail_DiscountInfo> list = detail_DiscountInfoDao.getDiscountInfosA(id);
		list.addAll(detail_DiscountInfoDao.getDiscountInfosB(id));
				
		return list;
	}

}
