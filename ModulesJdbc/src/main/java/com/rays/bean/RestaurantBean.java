package com.rays.bean;

public class RestaurantBean {
	private int itemId;
	private String itemName;
	private String category;
	private double price;
	private boolean isAvailable;
	
	/*
	 * # Field, Type, Null, Key, Default, Extra
'item_id', 'int', 'NO', 'PRI', NULL, ''
'item_name', 'varchar(45)', 'YES', '', NULL, ''
'category', 'varchar(45)', 'YES', '', NULL, ''
'price', 'bigint', 'YES', '', NULL, ''
'is_available', 'tinyint', 'YES', '', NULL, ''

	 * */
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
