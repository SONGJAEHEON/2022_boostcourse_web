package kr.or.connect.reservation.dto;

public class Detail_DiscountInfo {
	private String price_type_name;
	private int discount_rate;
	
	public String getPrice_type_name() {
		return price_type_name;
	}
	public void setPrice_type_name(String price_type_name) {
		this.price_type_name = price_type_name;
	}
	public int getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}
}
