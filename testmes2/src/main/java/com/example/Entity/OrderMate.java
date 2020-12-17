package com.example.Entity;

public class OrderMate{
	private String rawMateName;
	private int totalAmt;
	private int incomingAmt;
	private String parentNode;
	private String prodName;
	private String addDate;
	private String mateTypeCode;
	private int _no;
	
	public OrderMate() {
		
	}

	public OrderMate(String rawMateName, int totalAmt, int incomingAmt, String parentNode, String prodName,
			String addDate, String mateTypeCode) {
		super();
		this.rawMateName = rawMateName;
		this.totalAmt = totalAmt;
		this.incomingAmt = incomingAmt;
		this.parentNode = parentNode;
		this.prodName = prodName;
		this.addDate = addDate;
		this.mateTypeCode = mateTypeCode;
	}

	public String getMateTypeCode() {
		return mateTypeCode;
	}

	public void setMateTypeCode(String mateTypeCode) {
		this.mateTypeCode = mateTypeCode;
	}

	public String getRawMateName() {
		return rawMateName;
	}

	public void setRawMateName(String rawMateName) {
		this.rawMateName = rawMateName;
	}

	public int getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int getIncomingAmt() {
		return incomingAmt;
	}

	public void setIncomingAmt(int incomingAmt) {
		this.incomingAmt = incomingAmt;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public int get_no() {
		return _no;
	}

	public void set_no(int _no) {
		this._no = _no;
	}
	
	/*
	 * @Override public int compareTo(OrderMate orderMate) { // TODO Auto-generated
	 * method stub return this.addDate.compareTo(OrderMate.addDate); }
	 */
	
	
}
