package web.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import web.dao.IAddressDao;
import web.dao.util.SqlHelper;
import web.entity.Address;
public class AddressDaoImpl implements IAddressDao{
	
	 /*
	 * 添加地址
	 */
	@Override
	public int insertAddress(Address address) {	
		return SqlHelper.executeInsert("T_Address", address);
	}
	
	 /*
	 * 删除地址
	 */
	@Override
	public int deleteByAddressId(Integer aId) {
		return SqlHelper.executeNoQuery("delete from T_Address where aId="+aId);
	}
	
	/*
	 * 更新地址
	 */
	@Override
	public int updateByAddressId(Address address) {
		return SqlHelper.executeUpdate("T_Address", address, "where aId="+address.getaId());
	}
	
	/*
	 * 遍历所有地址
	 */
	@Override
	public List<Address> selectAddress(){
		return SqlHelper.executeQuery(Address.class,"select * from T_Address");
	}
	
	/*
	 * 分页查询
	 */
	@Override
	public List<Address> selectAddressByPage(int pageSize,int pageNow){
		return SqlHelper.executeQuery(Address.class,"select top "+pageSize+" * from T_Address where aid not in(select top "+pageNow+" aid from T_Address)");
	}

	@Override
	public List<Address> selectAddressByPage(int pageSize, int pageNow, int communityId) {
		// TODO Auto-generated method stub
		return SqlHelper.executeQuery(Address.class,"select top "+pageSize+" * from T_Address where communityId="+communityId+" and aid not in(select top "+pageNow+" aid from T_Address where communityId="+communityId+")");
	}
	
	/*
	 * 根据id查找地址
	 */
	@Override
	public Address selectAddressById(Integer aId) {
		return SqlHelper.executeQueryOne(Address.class, "select * from T_Address where aId="+aId);
	}
	
	/*
	 * 统计数据库中地址的总数（用于计算分页）
	 */
	@Override
	public int countAddress() {
		Integer count=0;
		try {
			ResultSet rs=SqlHelper.executeQuery("select Count(*) from T_Address");;
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	/*
	 * 统计指定用户的所有地址总数
	 */
	@Override
	public int countAddressByvipId(Integer vipId) {
		Integer count=0;
		try {
			ResultSet rs=SqlHelper.executeQuery("select Count(*) from T_Address where vipId="+vipId);;
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	
	/*
	 * 普通用户分页查询
	 */
	@Override
	public List<Address> selectUserAddressByPage(int getStartPos,int pageSize,Integer vipId){
		return SqlHelper.executeQuery(Address.class,"select top "+pageSize+" * from T_Address where vipId="+vipId+" and aid not in(select top "+getStartPos+" aid from T_Address where vipId="+vipId+")");
	}
	
	/*
	 * 获取指定用户的所有地址
	 */
	@Override
	public List<Address> selectAddressCount(Integer vipId){
		return SqlHelper.executeQuery(Address.class,"select * from T_Address where vipId="+vipId);
	}

	public static void main(String[] args) {
		/*Address address=new Address("1010", "1010", "1010", "1010", "1010", "1010");
		IAddressDao addresDao=new AddressDaoImpl();
		addresDao.insertAddress(address);*/
		/*Address address=new Address();
		address.setaId(7);
		address.setaName("OOOO");
		address.setaTel("1234584514");
		IAddressDao addressDao=new AddressDaoImpl();
		int i=addressDao.updateByAddressId(address);
		System.out.println(i);*/
		IAddressDao addressDao=new AddressDaoImpl();
		
		List<Address> us=addressDao.selectUserAddressByPage(5, 0, 3);
		for (Address address : us) {
			System.out.println(address.toString());
		}
		
		
	}

}
