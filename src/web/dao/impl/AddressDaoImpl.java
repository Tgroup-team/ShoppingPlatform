package web.dao.impl;

import java.util.List;

import web.dao.IAddress;
import web.dao.util.SqlHelper;
import web.entity.Address;
public class AddressDaoImpl implements IAddress{
	
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
		return SqlHelper.executeUpdate("T_Address", address, "where applyId="+address.getaId());
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
	
	/*
	 * 根据id查找地址
	 */
	@Override
	public Address selectAddressById(Integer aId) {
		return SqlHelper.executeQueryOne(Address.class, "select aId,aName,aName,aProvince,aCity,aArea,aDetailAddr from T_Address where"+aId);
	}
	
	/*
	 * 统计数据库中地址的总数（用于计算分页）
	 */
	@Override
	public int countAddress() {
		return SqlHelper.executeNoQuery("select Count(*) from T_Address");
	}
}
