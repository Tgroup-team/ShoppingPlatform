package web.entity;

import java.math.BigDecimal;

public class Product {
	private Integer productId;
	private Integer categoryId;
	private Category category;
	private String productName;
	private BigDecimal productPrice;

	private String productImages;
	private String productDescriptionImages;

	private Integer inventory;
	private String productState;

	private String suppliers;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", category=" + category
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productImages=" + productImages
				+ ", productDescriptionImages=" + productDescriptionImages + ", inventory=" + inventory
				+ ", productState=" + productState + ", suppliers=" + suppliers + "]";
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setProductPrice(BigDecimal productPrice) {
		if(productPrice!=null) {
			this.productPrice=productPrice.setScale(2,BigDecimal.ROUND_HALF_UP);
			return ;
		}
		this.productPrice = productPrice;
	}

	public String getProductImages() {
		return productImages;
	}

	public void setProductImages(String productImages) {
		this.productImages = productImages;
	}

	public String getProductDescriptionImages() {
		return productDescriptionImages;
	}

	public void setProductDescriptionImages(String productDescriptionImages) {
		this.productDescriptionImages = productDescriptionImages;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(String suppliers) {
		this.suppliers = suppliers;
	}

}
