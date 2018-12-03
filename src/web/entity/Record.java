package web.entity;

import java.util.Date;

public class Record {
	private int mPaymentId;
	private Date recordTime;
	private String recordtype;
	private String recordAmount;

	public int getmPaymentId() {
		return mPaymentId;
	}

	public void setmPaymentId(int mPaymentId) {
		this.mPaymentId = mPaymentId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getRecordtype() {
		return recordtype;
	}

	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}

	public String getRecordAmount() {
		return recordAmount;
	}

	public void setRecordAmount(String recordAmount) {
		this.recordAmount = recordAmount;
	}

}
