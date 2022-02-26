package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;

public interface ReservationService {
	public Reservation getReservationInfo(int id);
	public List<Detail_DiscountInfo> getRservationInfo_DiscountInfo(int id);
}
