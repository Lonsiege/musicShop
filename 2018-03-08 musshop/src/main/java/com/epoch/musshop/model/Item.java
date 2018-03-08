package com.epoch.musshop.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.epoch.musshop.common.ItemDTO;

@Entity
@Access(AccessType.FIELD)
@Table(name = "items", uniqueConstraints = {@UniqueConstraint(columnNames = "catalog_id", name = "catalog_id_unique")})
public class Item extends AbstractBaseEntity {
	@Column(name="catalog_id", nullable = false)
	@NotNull
	private int catalog;
	
	@Column(name="name", nullable = false)
	@NotNull
	private String name;
	
	@Column(name="manufactorer", nullable = false)
	@NotNull
	private String manufactorer;
	
	@Column(name="price", nullable = false)
	@NotNull
	private int price;
	
	@Column(name="stock", nullable = false)
	@NotNull 
	private int stock;
	
	@Column(name="imageurl", nullable = false)
	@NotNull 
	private String imageUrl;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	List<SaleItem> salesItems;
	
	public Item() {
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufactorer() {
		return manufactorer;
	}

	public void setManufactorer(String manufactorer) {
		this.manufactorer = manufactorer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

	public List<SaleItem> getSalesItems() {
		return salesItems;
	}



	public void setSalesItems(List<SaleItem> salesItems) {
		this.salesItems = salesItems;
	}

	

	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

	public int getCatalogId() {
		return catalog;
	}



	public void setCatalogId(int catalog) {
		this.catalog = catalog;
	}



	public Item(@NotNull int catalog, @NotNull String name, @NotNull String manufactorer, @NotNull int price,
			@NotNull int stock, @NotNull String imageUrl) {
		super();
		this.catalog = catalog;
		this.name = name;
		this.manufactorer = manufactorer;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
	}



	@Override
	public String toString() {
		return "Item [catalogId=" + catalog + ", name=" + name + ", manufactorer=" + manufactorer + ", price=" + price
				+ ", stock=" + stock + ", imageUrl=" + imageUrl + "]";
	}
	
	public static ItemDTO makeItemDTO(Item item){
		return new ItemDTO(item.getCatalogId(), item.getName(), item.getManufactorer(), item.getPrice(), item.getStock(), item.getImageUrl());
	}
	
	public static Item makeItem(ItemDTO item){
		return new Item(item.getCatalog(), item.getName(), item.getManufactorer(), item.getPrice(), item.getStock(), item.getImageUrl());
	}


	
	
	

	
}
