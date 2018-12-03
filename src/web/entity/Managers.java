package web.entity;

public class Managers {
	private Integer managerId;
	private String managerName;
	private String password;
	private Double money;

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

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public static Managers find(String managername2, String password2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Managers [managerId=" + managerId + ", managerName=" + managerName + ", password=" + password
				+ ", money=" + money + "]";
	}

}
