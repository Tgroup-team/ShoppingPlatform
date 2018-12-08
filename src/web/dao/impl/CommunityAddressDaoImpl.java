package web.dao.impl;

import java.util.List;

import web.dao.ICommunityAddressDao;
import web.dao.util.SqlHelper;
import web.entity.CommunityAddress;

public class CommunityAddressDaoImpl implements ICommunityAddressDao{
	
	/*
	 * 查询社团成员地址信息
	 */
	@Override
	public List<CommunityAddress> selectCommunityAddressByCommunityId(Integer communityId){
		return SqlHelper.executeQuery(CommunityAddress.class, 
				"SELECT o.vipId,o.vipName,o.communityId,a.* FROM T_User AS o "+
				"LEFT JOIN T_Address AS a ON o.vipId = a.vipId " + 
				"where o.communityId="+communityId);
	}
	/*
	 * 分页查询社团成员地址信息
	 */
	@Override
	public List<CommunityAddress> selectCommunityAddressPage(int pageSize,int pageNow,Integer communityId){
		return SqlHelper.executeQuery(CommunityAddress.class, 
				"SELECT top "+pageSize+" o.vipId,o.vipName,o.communityId,a.* "+
				"FROM T_User AS o LEFT JOIN T_Address AS a ON o.vipId = a.vipId "+
				"where o.communityId="+communityId+" and aid not in(select top "+pageNow+" aid from T_User)");
	}
	
	public static void main(String[] args) {
		/*CommunityAddressDaoImpl ca=new CommunityAddressDaoImpl();
		 List<CommunityAddress> te=ca.selectCommunityAddressByCommunityId(1);
		 for (CommunityAddress communityAddress : te) {
			System.out.println(communityAddress.toString());
		}*/
		
		CommunityAddressDaoImpl ca=new CommunityAddressDaoImpl();
		 List<CommunityAddress> te=ca.selectCommunityAddressPage(5, 0, 1);
		 for (CommunityAddress communityAddress : te) {
			System.out.println(communityAddress.toString());
		}
	}
	
	

}
