package com.example.Entity;

public class TempProcess {
	private String mateName;
	private String mateCode;
	private String mateTypeCode;
	private String addDate;
	private String processCode;
	private int amt;
	private int mateNo;
	
	public TempProcess() {
		
	}
	
	public TempProcess(String mateName, int amt, String addDate) { // 공정처리 품질검사에 사용
		super();
		this.mateName = mateName;
		this.addDate = addDate;
		this.amt = amt;
	}

	public TempProcess(String mateName, String mateCode, String mateTypeCode, String addDate, String processCode,
			int amt) {
		super();
		this.mateName = mateName;
		this.mateCode = mateCode;
		this.mateTypeCode = mateTypeCode;
		this.addDate = addDate;
		this.processCode = processCode;
		this.amt = amt;
	}
	
	public String getMateName() {
		return mateName;
	}
	public void setMateName(String mateName) {
		this.mateName = mateName;
	}
	public String getMateCode() {
		return mateCode;
	}
	public void setMateCode(String mateCode) {
		this.mateCode = mateCode;
	}
	public String getMateTypeCode() {
		return mateTypeCode;
	}
	public void setMateTypeCode(String mateTypeCode) {
		this.mateTypeCode = mateTypeCode;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getProcessCode() {
		return processCode;
	}
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}

	public int getMateNo() {
		return mateNo;
	}

	public void setMateNo(int mateNo) {
		this.mateNo = mateNo;
	}
	
	
}
