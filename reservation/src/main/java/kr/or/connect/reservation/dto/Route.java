package kr.or.connect.reservation.dto;

public class Route {
	private String save_file_name;
	private String place_street;
	private String place_lot;
	private String place_name;
	private String tel;
	
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getPlace_street() {
		return place_street;
	}
	public void setPlace_street(String place_street) {
		this.place_street = place_street;
	}
	public String getPlace_lot() {
		return place_lot;
	}
	public void setPlace_lot(String place_lot) {
		this.place_lot = place_lot;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
