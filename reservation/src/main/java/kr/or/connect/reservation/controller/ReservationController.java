package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/makingReservation")
	public String makeReservation(@RequestParam(value="id", required=true)int id, ModelMap model) {
		Reservation reservation = reservationService.getReservationInfo(id);
		List<Detail_DiscountInfo> discountList = reservationService.getRservationInfo_DiscountInfo(id);
		
		model.put("id", id);
		model.put("reservation", reservation);
		model.put("list", discountList);
		
		return "makeReservation";
	}
}
