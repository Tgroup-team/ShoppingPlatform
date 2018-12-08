package web.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TakeGood {
	private Integer orderId;
	private Integer vipId;
	private String orderstate;
	private Date delivery;
	private Date acceptance;
	
	private Date ordertime;
	private String productName;
	private String productImages;
	private String suppliers;
	@Override
	public String toString() {
		return "TakeGood [orderId=" + orderId + ", vipId=" + vipId + ", orderstate=" + orderstate + ", delivery="
				+ delivery + ", acceptance=" + acceptance + ", ordertime=" + ordertime + ", productName=" + productName
				+ ", productImages=" + productImages + ", suppliers=" + suppliers + "]";
	}
	public TakeGood(Integer orderId, Integer vipId, String orderstate, Date delivery, Date acceptance, Date ordertime,
			String productName, String productImages, String suppliers) {
		super();
		this.orderId = orderId;
		this.vipId = vipId;
		this.orderstate = orderstate;
		this.delivery = delivery;
		this.acceptance = acceptance;
		this.ordertime = ordertime;
		this.productName = productName;
		this.productImages = productImages;
		this.suppliers = suppliers;
	}
	public TakeGood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public Date getDelivery() {
		return delivery;
	}
	public void setDelivery(Date delivery) {
		this.delivery = delivery;
	}
	public Date getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(Date acceptance) {
		this.acceptance = acceptance;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImages() {
		return productImages;
	}
	public void setProductImages(String productImages) {
		this.productImages = productImages;
	}
	public String getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(String suppliers) {
		this.suppliers = suppliers;
	}
}
