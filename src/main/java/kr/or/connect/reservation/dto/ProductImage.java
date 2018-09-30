package kr.or.connect.reservation.dto;

public class ProductImage {
	private String save_file_name;

	public String getSave_file_name() {
		return save_file_name;
	}

	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}

	@Override
	public String toString() {
		return "ProductImage [save_file_name=" + save_file_name + "]";
	}
}
