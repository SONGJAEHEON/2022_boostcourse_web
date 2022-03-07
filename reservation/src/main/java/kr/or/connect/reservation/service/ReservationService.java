package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.Price;

public interface ReservationService {
	public Reservation getReservationInfo(int id);
	public List<Price> getRservationInfo_PriceInfo(int id);
}
