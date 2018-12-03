package web.dao;

import web.dao.util.SqlHelper;
import web.entity.Community;
import web.entity.User;

public class UserDao {
	
	public User selectByVipId(Integer vipId) {
		
		
		User user=SqlHelper.executeQueryOne(User.class, "select u.*,c.* from T_User u,T_Community c where c.communityId=u.communityId and vipId="+vipId);
		
		//user.setCommunity((Community)SqlHelper.executeQueryOne(Community.class, "select * from T_Community where communityId="+user.getCommunityId()));
		
		
		return user;
	}
	
	public static void main(String[] args) {
		User user=new User();
		user.setVipName("abc");
		user.setCommunityId(2);
		System.out.println(SqlHelper.executeInsert("T_User", user));
	}
}
