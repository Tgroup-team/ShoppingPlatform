package web.dao.impl;

import java.util.List;

import web.dao.IRecordDao;
import web.dao.util.SqlHelper;
import web.entity.Address;
import web.entity.Record;

/**
 * 	支付记录	数据层
 */
public class RecordDaoImpl implements IRecordDao{
	private static final String TABLENAME = "T_Record";

	/**
	 * 插入支付记录
	 */
	@Override
	public int insertRecord(Record record) {
		return SqlHelper.executeInsert(TABLENAME, record);
	}

	/**
	 * 通过主键删除支付记录
	 */
	@Override
	public int deleteRecord(Integer mPaymentId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where mPaymentId=" + mPaymentId);
	}

	/**
	 * 执行更新支付记录
	 */
	@Override
	public int updateRecord(Record record) {
		return SqlHelper.executeUpdate(TABLENAME, record, "where mPaymentId=" + record.getmPaymentId());
	}

	/**
	 * 查询所有支付记录
	 */
	@Override
	public List<Record> selectRecord() {
		return SqlHelper.executeQuery(Record.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个支付记录
	 */
	@Override
	public Record selectRecord(Integer mPaymentId) {
		return SqlHelper.executeQueryOne(Record.class,
				"select * from " + TABLENAME + " where mPaymentId=" + mPaymentId);
	}
	
	/*
	 * 分页查询
	 */
	@Override
	public List<Record> selectRecordByPage(int pageSize,int pageNow){
		return SqlHelper.executeQuery(Record.class,"select top "+pageSize+" * from T_Record where mPaymentId not in(select top "+pageNow+" mPaymentId from T_Record)");
	}
	

}
