package com.shop.shopping.domain;

import java.util.Date;

public class ReplyListVO {
/*
 * CREATE TABLE tbl_reply (
gdsNum int 			NOT NULL,
userId VARCHAR(50) 	NOT NULL,
repNum int 			NOT NULL,
repCon VARCHAR(2000) NOT NULL,
repDate DATE			DEFAULT NOW(),
PRIMARY KEY (gdsNum, repNum)
);

 * */
	private int gdsNum;
	private String userId;
	private int repNum;
	private String repCon;
	private Date repDate;
	
	private String userName;
	
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
