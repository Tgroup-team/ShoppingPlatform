package web.dao;

import web.dao.util.SqlHelper;
import web.entity.Community;
import web.entity.User;

public class UserDao {
	
	public User selectByVipId(Integer vipId) {
		
		
		User user=SqlHelper.executeQueryOne(User.class, "select * from T_User where vipId="+vipId);
		
		user.setCommunity((Community)SqlHelper.executeQueryOne(Community.class, "select * from T_Community where communityId="+user.getCommunityId()));
		
		
		return user;
	}
	
	public static void main(String[] args) {
		User user=new User();
		user.setVipId(2);
		user.setVipName("abc");
	
		
		
		System.out.println(new UserDao().selectByVipId(2));
	}
}
