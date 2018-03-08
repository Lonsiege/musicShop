package com.epoch.musshop.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.FIELD)
@Table(name = "sales")
public class Sale extends AbstractBaseEntity {
	@Column(name="email", nullable = false)
	@NotNull
	private String email;
	
	@Column(name="sum", nullable = false)
	@NotNull
	private int sum;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
	List<SaleItem> salesItems;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
	List<SaleCombo> salesCombo;	

	public Sale() {
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	public List<SaleItem> getSalesItems() {
		return salesItems;
	}


	public void setSalesItems(List<SaleItem> salesItems) {
		this.salesItems = salesItems;
	}


	@Override
	public String toString() {
		return "Sale [email=" + email + ", sum=" + sum + "]";
	}


	public List<SaleCombo> getSalesCombo() {
		return salesCombo;
	}


	public void setSalesCombo(List<SaleCombo> salesCombo) {
		this.salesCombo = salesCombo;
	}


	public Sale(@NotNull String email, @NotNull int sum) {
		super();
		this.email = email;
		this.sum = sum;
	}


	
	
		
}
