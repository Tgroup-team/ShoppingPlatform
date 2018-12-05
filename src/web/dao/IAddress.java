package web.dao;

import java.util.List;
import web.entity.Address;

public interface IAddress {
	public int insertAddress(Address address);
	
	 /*
	 * 删除地址
	 */
	public int deleteByAddressId(Integer aId);
	
	/*
	 * 更新地址
	 */
	public int updateByAddressId(Address address);
	
	/*
	 * 遍历所有地址
	 */
	public List<Address> selectAddress();
	
	/*
	 * 分页查询
	 */
	public List<Address> selectAddressByPage(int pageSize,int pageNow);
	
	/*
	 * 根据id查找地址
	 */
	public Address selectAddressById(Integer aId);
	
	/*
	 * 统计数据库中地址的总数（用于计算分页）
	 */
	public int countAddress();
}
