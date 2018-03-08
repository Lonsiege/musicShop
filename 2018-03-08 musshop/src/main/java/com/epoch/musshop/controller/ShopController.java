package com.epoch.musshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epoch.musshop.common.CommonDTO;
import com.epoch.musshop.common.ItemDTO;
import com.epoch.musshop.common.StatDTO;
import com.epoch.musshop.model.Item;

import static com.epoch.musshop.common.AppConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping
public class ShopController {
	
	@Value("${shop_stat_bestseller_limit}")
	int bestsellerLimit;
	
	@Value("${shop_stat_combos_limit}")
	int combosLimit;
	
	private ShopManager manager;
	
	@Autowired
	public ShopController(ShopManager manager) {
		super();
		this.manager = manager;
	}
	
	@GetMapping(value = GETITEMS)
	public CommonDTO getItems() {
		List<Item> itemsList = manager.getItemsByPop();
		return itemsList.size() == 0 ? new CommonDTO(FALSE, NODATA) : new CommonDTO(TRUE, 
				itemsList.stream().map(Item::makeItemDTO).collect(Collectors.toList()));			
	}
	
	@GetMapping(value = GETSTAT)
	public CommonDTO getStat() {
		
		List<ItemDTO> bestSellersDto = new ArrayList<>();
		List<Item> bestSellers = manager.getBestSellerItems(bestsellerLimit);
		if(bestSellers.size() > 0 ) bestSellersDto = bestSellers.stream().map(Item::makeItemDTO).collect(Collectors.toList());
		
		List<List<ItemDTO>> topCombos = manager.getBestCombos(combosLimit);
		
		StatDTO stat = new StatDTO(bestSellersDto, topCombos);
		return new CommonDTO(TRUE, stat	);			
	}
	
	@RequestMapping(value = SAVESALE, method = RequestMethod.POST)
	public CommonDTO saveOrders(@RequestBody Map<String, Object> params) {
		CommonDTO res = manager.saveOrder(params);
		return new CommonDTO(TRUE, res);			
	}
	
	
	
}
