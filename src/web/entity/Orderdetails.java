package web.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orderdetails {
	private Integer detailsId;

	private Order order;
	private Integer orderId;

	private Product product;
	private Integer productId;
	private Integer amount;
	private BigDecimal price;
	private BigDecimal total;
	private Date ordertime;
	
	@Override
	public String toString() {
		return "Orderdetails [detailsId=" + detailsId + ", order=" + order + ", orderId=" + orderId + ", product="
				+ product + ", productId=" + productId + ", amount=" + amount + ", price=" + price + ", total=" + total
				+ ", ordertime=" + ordertime + "]";
	}

	public Integer getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

}
