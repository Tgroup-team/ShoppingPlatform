package web.dao.impl;

import java.util.List;

import web.dao.IUserDao;
import web.dao.util.SqlHelper;
import web.entity.Address;
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
	 * 执行更新用户信息
	 */
	@Override
	public int updateUserCommunityIdByCommunityId(Integer communityId) {
		return SqlHelper.executeNoQuery("update "+TABLENAME+" set communityId=1 where communityId=" + communityId);
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
		return user;
	}
	
	
	/*
	 * 分页查询
	 */
	@Override
	public List<User> selectUserByPage(int pageSize,int pageNow){
		return SqlHelper.executeQuery(User.class,"select top "+pageSize+" * from T_User where vipId not in(select top "+pageNow+" vipId from T_User)");
	}
	
	/*
	 * 分页查询2
	 */
	@Override
	public List<User> selectUserByPage(int pageSize,int pageNow,Integer communityId){
		return SqlHelper.executeQuery(User.class,"select top "+pageSize+" * from T_User where communityId="+communityId+" and vipId not in(select top "+pageNow+" vipId from T_User where communityId="+communityId+")");
	}

	/*
	 * 查询社团成员 
	 */
	@Override
	public List<User> selectUserByCommunity(Integer communityId) {
		return SqlHelper.executeQuery(User.class, "select * from " + TABLENAME +" where communityId=" + communityId);
	}

	public static void main(String[] args) {
		User user=new User("小猫", "111111", "123456789", "天使大街");
		IUserDao uDao=new UserDaoImpl();
		int i=uDao.insertUser(user);
		System.out.println(i);
	}

}
