package com.epoch.musshop.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Access(AccessType.FIELD)
@Table(name = "salesitems")
public class SaleItem extends AbstractBaseEntity {
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "sale_id")
	    private Sale sale;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 	@JoinColumn(name = "item_id")
	 	private Item item;

	public SaleItem() {
	}

	public SaleItem(Sale sale, Item item) {
		super();
		this.sale = sale;
		this.item = item;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SaleItem [sale=" + sale + ", item=" + item + "]";
	}
	 
	 
}
