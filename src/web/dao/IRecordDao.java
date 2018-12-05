package web.dao;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Record;

public interface IRecordDao {

	/**
	 * 插入支付记录
	 */
	public int insertRecord(Record record);

	/**
	 * 通过主键删除支付记录
	 */
	public int deleteRecord(Integer mPaymentId);

	/**
	 * 执行更新支付记录
	 */
	public int updateRecord(Record record);

	/**
	 * 查询所有支付记录
	 */
	public List<Record> selectRecord();

	/**
	 * 通过主键查询单个支付记录
	 */
	public Record selectRecord(Integer mPaymentId);

}
