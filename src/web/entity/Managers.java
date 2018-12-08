package web.entity;

import java.math.BigDecimal;

public class Managers {
	private Integer managerId;
	private String managerName;
	private String password;
	private BigDecimal money;

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPassword() {
		return password;
	}

	
	
	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
