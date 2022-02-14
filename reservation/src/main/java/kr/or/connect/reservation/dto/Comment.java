package kr.or.connect.reservation.dto;

import java.util.StringTokenizer;

public class Comment {
	private String description;
	private String comment;
	private int score;
	private String reservation_email;
	private String modify_date;
	private String save_file_name;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReservation_email() {
		return reservation_email;
	}
	public void setReservation_email(String reservation_email) {
		StringTokenizer stk=new StringTokenizer(reservation_email,"@");
			
		this.reservation_email = stk.nextToken();
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	
	
}
