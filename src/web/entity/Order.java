package web.entity;

import java.util.Date;

public class Order {
	private Integer orderId;

	private User user;
	private Integer vipId;
	//订单状态 发货，待发货，已收货
	private String orderstate;
	private Date delivery;
	
	private Date acceptance;
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", vipId=" + vipId + ", orderstate=" + orderstate
				+ ", delivery=" + delivery + ", acceptance=" + acceptance + "]";
	}



	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

}
