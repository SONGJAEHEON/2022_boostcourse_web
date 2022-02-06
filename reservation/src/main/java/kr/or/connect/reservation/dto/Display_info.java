package kr.or.connect.reservation.dto;

public class Display_info {
//	product.id, product.description, product.content, display_info.place_name, file_info.save_file_name
	private int id;
	private String description;
	private String content;
	private String place_name;
	private String save_file_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	
	@Override
	public String toString() {
		return "Display_info [id=" + id + ", description=" + description + ", content=" + content + ", place_name="
				+ place_name + ", save_file_name=" + save_file_name + "]";
	}
}
