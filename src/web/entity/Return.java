package web.entity;

import java.util.Date;

public class Return {
	private int returnId;

	private int productId;
	private Product product;
	private int vipId;
	private User user;

	private Float total;
	private String returnstate;
	private Date applytime;
	private int amount;
	private String processingstate;
	private Float productprice;
	private Date returnTime;

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getReturnstate() {
		return returnstate;
	}

	public void setReturnstate(String returnstate) {
		this.returnstate = returnstate;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProcessingstate() {
		return processingstate;
	}

	public void setProcessingstate(String processingstate) {
		this.processingstate = processingstate;
	}

	public Float getProductprice() {
		return productprice;
	}

	public void setProductprice(Float productprice) {
		this.productprice = productprice;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

}
