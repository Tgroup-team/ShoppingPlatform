package web.dao.impl;

import java.util.List;

import web.dao.IUserDao;
import web.dao.util.SqlHelper;
import web.entity.User;

/**
 * 	用户信息	数据层
 */
public class UserDaoImpl implements IUserDao{
	private static final String TABLENAME = "T_User";

	/**
	 * 插入用户信息
	 */
	public int insertUser(User User) {
		return SqlHelper.executeInsert(TABLENAME, User);
	}

	/**
	 * 通过主键删除用户信息
	 */
	@Override
	public int deleteUser(Integer vipId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where vipId=" + vipId);
	}

	/**
	 * 执行更新用户信息
	 */
	@Override
	public int updateUser(User User) {
		return SqlHelper.executeUpdate(TABLENAME, User, "where vipId=" + User.getVipId());
	}

	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<User> selectUser() {
		return SqlHelper.executeQuery(User.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个用户信息
	 */
	@Override
	public User selectUser(Integer vipId) {
		return SqlHelper.executeQueryOne(User.class,
				"select * from " + TABLENAME + " where vipId=" + vipId);
	}
	/**
	 * 通过姓名查询单个用户信息
	 */
	@Override
	public User selectByVipName(String uname) {
		
		User user=SqlHelper.executeQueryOne(User.class, 
			"select * from T_User where vipName='"+uname+"'");
		/*user.setCommunity((Community)SqlHelper.executeQueryOne(Community.class, 
		"select * from T_Community where communityId="+user.getCommunityId()));*/

		return user;
	}

}
