package com.epoch.musshop.common;

public class ItemDTO {
	private int catalog;
	private String name;
	private String manufactorer;
	private int price;
	private int stock;
	private String imageUrl;
	
	public ItemDTO() {
	}

	public int getCatalog() {
		return catalog;
	}

	public String getName() {
		return name;
	}

	public String getManufactorer() {
		return manufactorer;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public ItemDTO(int catalog, String name, String manufactorer, int price, int stock, String imageUrl) {
		super();
		this.catalog = catalog;
		this.name = name;
		this.manufactorer = manufactorer;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
	}
		
	
}
