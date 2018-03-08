package com.epoch.musshop.common;

import java.util.List;


public class StatDTO {
	private List<ItemDTO> bestSellers;
	private List<List<ItemDTO>> bestCombos;
	
	public StatDTO() {
	}

	public List<ItemDTO> getBestSellers() {
		return bestSellers;
	}

	public List<List<ItemDTO>> getBestCombos() {
		return bestCombos;
	}

	public StatDTO(List<ItemDTO> bestSellers, List<List<ItemDTO>> bestCombos) {
		this.bestSellers = bestSellers;
		this.bestCombos = bestCombos;
	}	
	
}
