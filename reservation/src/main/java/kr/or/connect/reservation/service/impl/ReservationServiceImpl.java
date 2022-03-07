package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PriceDao;
import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	PriceDao priceDao;
	
	@Override
	@Transactional
	public Reservation getReservationInfo(int id) {
		Reservation rv = reservationDao.select(id);
		
		return rv;
	}

	@Override
	@Transactional
	public List<Price> getRservationInfo_PriceInfo(int id) {
		List<Price> list = priceDao.getPriceInfos(id);
				
		return list;
	}

}
