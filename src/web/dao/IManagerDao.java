package web.dao;

import web.entity.Managers;

public interface IManagerDao {
	// 查询用户名
	public Managers seleteByManagerName(String managerName);

	// 查询密码
	public Managers seleteByPassword(String password);
}
