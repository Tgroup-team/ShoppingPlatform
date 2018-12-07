package web.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Return {
	private Integer returnId;

	private Integer productId;
	private Product product;
	private Integer vipId;
	private User user;

	private BigDecimal total;
	private String returnstate;
	private Date applytime;
	private Integer amount;
	private String processingstate;
	private BigDecimal productprice;
	private Date returnTime;

	public Integer getReturnId() {
		return returnId;
	}

	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getProcessingstate() {
		return processingstate;
	}

	public void setProcessingstate(String processingstate) {
		this.processingstate = processingstate;
	}

	public BigDecimal getProductprice() {
		return productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

}
