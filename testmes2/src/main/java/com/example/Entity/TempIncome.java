package com.example.Entity;

public class TempIncome {
	private String rawMateName;
	private String parentNode;
	private String addDate;
	private int myIncomeAmt;
	private int passAmt;
	private String mateTypeCode;
	
	public TempIncome() {
		
	}
	
	public TempIncome(String rawMateName, String parentNode, String addDate, int myIncomeAmt) {
		super();
		this.rawMateName = rawMateName;
		this.parentNode = parentNode;
		this.addDate = addDate;
		this.myIncomeAmt = myIncomeAmt;
	}
	
	
	
	public TempIncome(String rawMateName, String parentNode, String addDate, int myIncomeAmt, int passAmt,
			String mateTypeCode) {
		super();
		this.rawMateName = rawMateName;
		this.parentNode = parentNode;
		this.addDate = addDate;
		this.myIncomeAmt = myIncomeAmt;
		this.passAmt = passAmt;
		this.mateTypeCode = mateTypeCode;
	}

	public String getMateTypeCode() {
		return mateTypeCode;
	}

	public void setMateTypeCode(String mateTypeCode) {
		this.mateTypeCode = mateTypeCode;
	}

	public int getPassAmt() {
		return passAmt;
	}

	public void setPassAmt(int passAmt) {
		this.passAmt = passAmt;
	}

	public String getRawMateName() {
		return rawMateName;
	}
	public void setRawMateName(String rawMateName) {
		this.rawMateName = rawMateName;
	}
	public String getParentNode() {
		return parentNode;
	}
	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public int getMyIncomeAmt() {
		return myIncomeAmt;
	}
	public void setMyIncomeAmt(int myIncomeAmt) {
		this.myIncomeAmt = myIncomeAmt;
	}
	
	
}
