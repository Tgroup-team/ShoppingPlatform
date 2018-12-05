package web.dao;

import java.util.List;

import web.entity.User;

public interface IUserDao {

	/**
	 * 插入用户信息
	 */
	public int insertUser(User User);

	/**
	 * 通过主键删除用户信息
	 */
	public int deleteUser(Integer vipId);

	/**
	 * 执行更新用户信息
	 */
	public int updateUser(User User);

	/**
	 * 查询所有用户信息
	 */
	public List<User> selectUser();

	/**
	 * 通过主键查询单个用户信息
	 */
	public User selectUser(Integer vipId);
	public User selectByVipName(String uname);

}
