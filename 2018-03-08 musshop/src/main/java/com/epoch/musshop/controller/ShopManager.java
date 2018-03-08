package com.epoch.musshop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epoch.musshop.common.CommonDTO;
import com.epoch.musshop.common.ItemDTO;
import com.epoch.musshop.model.*;
import com.epoch.musshop.repo.*;

import static com.epoch.musshop.common.AppConstants.*;
@Component
public class ShopManager implements ShopOperations {
	
	private ComboRepository comboRepo;
	private ItemRepository itemRepo;
	private SaleComboRepository saleCombRepo;
	private SaleItemRepository saleItemRepo;
	private SaleRepository saleRepo;	
	
	@Autowired
	public ShopManager(ComboRepository comboRepo, ItemRepository itemRepo, SaleComboRepository saleCombRepo,
			SaleItemRepository saleItemRepo, SaleRepository saleRepo) {
		this.comboRepo = comboRepo;
		this.itemRepo = itemRepo;
		this.saleCombRepo = saleCombRepo;
		this.saleItemRepo = saleItemRepo;
		this.saleRepo = saleRepo;
	}

	@Override
	public List<Item> getItemsByPop() {		
		return (List<Item>) itemRepo.getByPop();
	}

	@Override
	public CommonDTO saveOrder(Map<String, Object> params) {
		List<Integer> itemsNumbers = (List<Integer>) params.get(CART);
		Collections.sort(itemsNumbers);
		itemsNumbers.forEach(System.out::println);
		List<Item> items = getAllByCatalog(itemsNumbers);
		
		String email = (String) params.get(EMAIL);
		
		int amount = items.stream().mapToInt(Item::getPrice).sum();
		Sale sale = new Sale(email, amount);
		saleRepo.save(sale);
		items.forEach(x->{
			saleItemRepo.save(new SaleItem(sale, x));
		});
		if(items.size()>1){
			updateComboData(items, sale);			
		}
		return new CommonDTO(TRUE, SALESAVED);
	}

	private void updateComboData(List<Item> items, Sale sale) {
		String comboId = items.stream().map(n-> String.valueOf(n.getCatalogId())).collect(Collectors.joining(" "));
		Combo combo = comboRepo.findByCombine(comboId);
		
		if(combo == null){
			combo = new Combo(comboId, 1);
			comboRepo.save(combo);
		}
		else {
			combo.setCounter(combo.getCounter()+1);
			comboRepo.save(combo);			
		}
		saleCombRepo.save(new SaleCombo(sale, combo));
	}

	@Override
	public List<Item> getBestSellerItems(int limit) {	
		return (List<Item>) itemRepo.getTopBestSeller(limit);
	}

	@Override
	public List<List<ItemDTO>> getBestCombos(int limit) {
		List<Combo> combos = (List<Combo>) comboRepo.getTopCombos(limit);
		List<List<ItemDTO>> res = new ArrayList<>();
		combos.forEach(x->{
			res.add(parseCombo(x));
		});
		return res;
	}
	
	private List<ItemDTO> parseCombo(Combo combo){
		List<ItemDTO> res = new ArrayList<>();
		String[] comboCodes = (combo.getCombine().split(" "));
		for(int i=0; i<comboCodes.length;i++){
			res.add(Item.makeItemDTO(itemRepo.findByCatalog(Integer.parseInt(comboCodes[i]))));
		}
		return res;
	}

	@Override
	public List<Item> getAllByCatalog(List<Integer> list) {	
		List<Item> res = new ArrayList<>();		
		list.forEach(x->{
			res.add(itemRepo.findByCatalog(x));
		});
		return res;
	}
	
	

}
