package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BalanceEntity {

	@Id
	private int balanceId;
	private long balanceAmount;
	private String createdAt;
	private String updatedAt;
	
	
	
	public int getBalanceId() {
		return balanceId;
	}
	public void setBalanceId(int balanceId) {
		this.balanceId = balanceId;
	}
	public long getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
