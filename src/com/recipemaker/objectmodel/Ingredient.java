package com.recipemaker.objectmodel;

import java.util.Date;

public class Ingredient {
	
	private String item;
	private Integer amount;
	private Unit unit;
	private Date useBy;
	

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Date getUseBy() {
		return useBy;
	}
	public void setUseBy(Date useBy) {
		this.useBy = useBy;
	}
	
	public String toString() {
		return "(" + item + ", " + amount + ", " + unit + ", " + useBy + ")";
 	}


}
