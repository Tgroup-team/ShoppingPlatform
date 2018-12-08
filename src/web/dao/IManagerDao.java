package web.dao;

import web.entity.Managers;

public interface IManagerDao {
	// 查询用户名
	public Managers seleteByManagerName(String managerName);

	// 查询密码
	public Managers seleteByPassword(String password);
	
	//通过managerId修改
	public int updateByManagerId(Managers managers);
	
	//登录
	public Managers loginManagers(String managerName,String password); 
	
}
