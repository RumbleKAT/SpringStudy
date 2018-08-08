package kr.or.connect.reservation.dto;

public class Promotion {
	private long id;
	private long productId;
	private long categoryId;
	private String categoryName;
	private String description;
	private long productImageId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(long productImageId) {
		this.productImageId = productImageId;
	}
	
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", description=" + description + ", productImageId=" + productImageId + "]";
	}
}
