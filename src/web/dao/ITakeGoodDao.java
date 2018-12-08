package web.dao;

import java.util.List;

import web.entity.TakeGood;

public interface ITakeGoodDao  {

	/*
	 * 收货地址（三表信息合并）
	 */
	public List<TakeGood> selectTakeGoodByvipId(Integer vipId);

	/*
	 * 分页（三表信息合并）
	 */
	List<TakeGood> selectTakeGoodByPage(int pageSize, int pageNow, Integer vipId);

}
