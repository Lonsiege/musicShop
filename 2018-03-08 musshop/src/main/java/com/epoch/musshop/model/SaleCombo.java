package com.epoch.musshop.model;

import javax.persistence.*;


@Entity
@Access(AccessType.FIELD)
@Table(name="salescombo")
public class SaleCombo extends AbstractBaseEntity{
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "sale_id")
	    private Sale sale;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 	@JoinColumn(name = "combo_id")
	 	private Combo combo;

	public SaleCombo() {
	}

	public SaleCombo(Sale sale, Combo combo) {
		super();
		this.sale = sale;
		this.combo = combo;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	 
	
	 
}
