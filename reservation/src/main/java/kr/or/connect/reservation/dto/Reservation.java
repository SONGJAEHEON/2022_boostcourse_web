package kr.or.connect.reservation.dto;

public class Reservation {
	private String description;
	private int lowPrice;
	private String openingHour;
	private int reservationCnt;
	private String placeStreet;
	private String placeLot;

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getOpeningHour() {
		return openingHour;
	}
	public void setOpeningHour(String openingHour) {
		this.openingHour = openingHour;
	}
	public int getReservationCnt() {
		return reservationCnt;
	}
	public void setReservationCnt(int reservationCnt) {
		this.reservationCnt = reservationCnt;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	
}
