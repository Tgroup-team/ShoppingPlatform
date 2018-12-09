package web.dao.impl;

import java.util.List;

import web.dao.ICommunityAddressDao;
import web.dao.util.SqlHelper;
import web.entity.CommunityAddress;

public class CommunityAddressDaoImpl implements ICommunityAddressDao{
	
	/*
	 * 查询社团成员地址信息
	 */
	/*@Override
	public List<CommunityAddress> selectCommunityAddressByCommunityId(Integer communityId){
		return SqlHelper.executeQuery(CommunityAddress.class, 
				"SELECT o.vipId,o.vipName,o.communityId,a.* FROM T_User AS o "+
				"LEFT JOIN T_Address AS a ON o.vipId = a.vipId " + 
				"where o.communityId="+communityId);
	}*/
	
	/*
	 * 查询社团成员地址信息
	 */
	@Override
	public List<CommunityAddress> selectCommunityAddressByCommunityId(Integer communityId){
		return SqlHelper.executeQuery(CommunityAddress.class, 
				"SELECT o.vipId,o.vipName,o.communityId,a.* FROM T_User AS o,T_Address AS a "+
				"where o.vipId = a.vipId and o.communityId="+communityId);
	}
	
	/*
	 * 分页查询社团成员地址信息
	 */
	@Override
	public List<CommunityAddress> selectCommunityAddressPage(int pageSize,int pageStartPos,Integer communityId){
		String sql="SELECT top "+pageSize+" o.vipId,o.vipName,o.communityId,a.* "+
				"FROM T_Address AS a LEFT JOIN T_User AS o ON o.vipId = a.vipId "+
				"where o.communityId="+communityId+" and aid not in(select top "+pageStartPos+" a.aid from T_Address AS a LEFT JOIN T_User AS o ON o.vipId = a.vipId where o.communityId="+communityId+")";
		System.out.println(sql);
		return SqlHelper.executeQuery(CommunityAddress.class,sql);
	}
	
	public static void main(String[] args) {
		/*CommunityAddressDaoImpl ca=new CommunityAddressDaoImpl();
		 List<CommunityAddress> te=ca.selectCommunityAddressByCommunityId(1);
		 System.out.println(te.size());
		 for (CommunityAddress communityAddress : te) {
			System.out.println(communityAddress.toString());
		}*/
		
		CommunityAddressDaoImpl ca=new CommunityAddressDaoImpl();
		 List<CommunityAddress> te=ca.selectCommunityAddressPage(5, 5, 1);
		 for (CommunityAddress communityAddress : te) {
			System.out.println(communityAddress.toString());
		}
	}
	
	

}
