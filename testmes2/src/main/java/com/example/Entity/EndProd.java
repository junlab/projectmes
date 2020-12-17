package com.example.Entity;

import java.util.Date;

public class EndProd implements Comparable<EndProd>{
	
	private String prodName;
	private int amount;
	private String addDate;
	private int _no;
	
	public EndProd() {
		
	}
	
	public EndProd(String prodName, int amount, String addDate) {
		this.prodName = prodName;
		this.amount = amount;
		this.addDate = addDate;
	}

	

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	@Override
	public int compareTo(EndProd prodReq) {
		// TODO Auto-generated method stub
		return this.addDate.compareTo(prodReq.addDate);
	}

	public int get_no() {
		return _no;
	}

	public void set_no(int _no) {
		this._no = _no;
	}

	
	

	
	
	
	
}
