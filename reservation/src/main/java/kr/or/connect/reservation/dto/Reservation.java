package kr.or.connect.reservation.dto;

public class Reservation {
	private String description;
	private String fileName;
	private int lowPrice;
	private String openingHour1;
	private String openingHour2;
	private int reservationCnt;
	private String placeStreet;
	private String placeLot;

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getOpeningHour1() {
		return openingHour1;
	}
	public void setOpeningHour1(String openingHour1) {
		this.openingHour1 = openingHour1;
	}
	public String getOpeningHour2() {
		return openingHour2;
	}
	public void setOpeningHour2(String openingHour2) {
		this.openingHour2 = openingHour2;
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
