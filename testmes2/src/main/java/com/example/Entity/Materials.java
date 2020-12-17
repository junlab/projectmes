package com.example.Entity;

public class Materials {
	private String mateName;
	private String mateCode;
	private String mateTypeCode;
	private String mateTypeName;
	private String parentNode;
	private String addDate;
	private String processCode;
	private String processName;
	private String workState;
	private int passAmt;
	private int mateNo;
	private int amt;
	private int glassesAmt; //         
	
	
	public Materials() {
		
	}

	public Materials(String mateName, String mateTypeName, String processName, int amt, String parentNode, String addDate) { // 임시 공정처리 검사를 위해 데이터 넘길 때 사용
		super();
		this.mateName = mateName;
		this.mateTypeName = mateTypeName;
		this.processName = processName;
		this.parentNode = parentNode;
		this.addDate = addDate;
		this.amt = amt;
	}

	public Materials(String mateName, String parentNode, String addDate, int passAmt) {
		super();
		this.mateName = mateName;
		this.parentNode = parentNode;
		this.addDate = addDate;
		this.passAmt = passAmt;
	}
	
	public Materials(String mateName, String mateCode, String parentNode, String addDate, String processCode,
			String workState, int mateNo, int amt) {
		super();
		this.mateName = mateName;
		this.mateCode = mateCode;
		this.parentNode = parentNode;
		this.addDate = addDate;
		this.processCode = processCode;
		this.workState = workState;
		this.mateNo = mateNo;
		this.amt = amt;
	}
	
	
	public Materials(String mateName, String mateCode, String mateTypeCode, String parentNode,
			String addDate, String processCode, String workState, int passAmt, int mateNo, int amt) {
		super();
		this.mateName = mateName;
		this.mateCode = mateCode;
		this.mateTypeCode = mateTypeCode;
		this.parentNode = parentNode;
		this.addDate = addDate;
		this.processCode = processCode;
		this.workState = workState;
		this.passAmt = passAmt;
		this.mateNo = mateNo;
		this.amt = amt;
	}

	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getMateTypeName() {
		return mateTypeName;
	}

	public void setMateTypeName(String mateTypeName) {
		this.mateTypeName = mateTypeName;
	}

	public String getMateTypeCode() {
		return mateTypeCode;
	}

	public void setMateTypeCode(String mateTypeCode) {
		this.mateTypeCode = mateTypeCode;
	}
	
	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getMateCode() {
		return mateCode;
	}

	public void setMateCode(String mateCode) {
		this.mateCode = mateCode;
	}

	 public int getMateNo() { return mateNo; }
	  
	 public void setMateNo(int mateNo) { this.mateNo = mateNo; }
	
	public int getPassAmt() {
		return passAmt;
	}

	public void setPassAmt(int passAmt) {
		this.passAmt = passAmt;
	}

	public String getMateName() {
		return mateName;
	}
	public void setMateName(String mateName) {
		this.mateName = mateName;
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

	public int getGlassesAmt() {
		return glassesAmt;
	}

	public void setGlassesAmt(int glassesAmt) {
		this.glassesAmt = glassesAmt;
	}

	
}
