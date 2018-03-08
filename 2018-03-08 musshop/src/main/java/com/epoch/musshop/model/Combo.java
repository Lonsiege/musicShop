package com.epoch.musshop.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.FIELD)
@Table(name = "combo", uniqueConstraints = {@UniqueConstraint(columnNames = "combine", name = "combo_unique_combine")})
public class Combo extends AbstractBaseEntity {
	@Column(name="combine", nullable = false)
	@NotNull
	private String combine;
	
	@Column(name="counter", nullable = false)
	@NotNull
	private int counter;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "combo")
	List<SaleCombo> salesCombo;	
	
	public Combo() {
	}

	public String getCombine() {
		return combine;
	}

	public void setCombine(String combine) {
		this.combine = combine;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "Combo [combine=" + combine + ", counter=" + counter + "]";
	}

	public List<SaleCombo> getSalesCombo() {
		return salesCombo;
	}

	public void setSalesCombo(List<SaleCombo> salesCombo) {
		this.salesCombo = salesCombo;
	}

	public Combo(@NotNull String combine, @NotNull int counter) {
		super();
		this.combine = combine;
		this.counter = counter;
	}
	
	
	
	
	
	
}
