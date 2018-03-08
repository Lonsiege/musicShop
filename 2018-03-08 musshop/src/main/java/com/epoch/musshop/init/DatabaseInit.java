package com.epoch.musshop.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epoch.musshop.common.ItemDTO;
import com.epoch.musshop.controller.ShopManager;
import com.epoch.musshop.model.*;
import com.epoch.musshop.repo.*;

@Component
public class DatabaseInit implements ApplicationRunner{
	
	
	private ComboRepository comboRepo;
	private ItemRepository itemRepo;
	private SaleComboRepository saleCombRepo;
	private SaleItemRepository saleItemRepo;
	private SaleRepository saleRepo;	
	private ShopManager manager;
	
	@Autowired
	public DatabaseInit(ComboRepository comboRepo, ItemRepository itemRepo, SaleComboRepository saleCombRepo,
			SaleItemRepository saleItemRepo, SaleRepository saleRepo, ShopManager manager) {
		super();
		this.comboRepo = comboRepo;
		this.itemRepo = itemRepo;
		this.saleCombRepo = saleCombRepo;
		this.saleItemRepo = saleItemRepo;
		this.saleRepo = saleRepo;
		this.manager = manager;
	}




	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Item item1 = new Item(1, "Stratocaster", "Fender", 200, 4, "1");
		Item item2 = new Item(2, "Les Paul", "Gibson", 200, 5,  "2");
		Item item3 = new Item(3, "RGV", "Ibanez", 300, 4, "3");
		Item item4 = new Item(4, "Aelita", "Ural", 100, 2,  "4");
		Item item5 = new Item(5, "333XL", "Bugera", 50, 2,  "5");
		Item item6 = new Item(6, "Eod 88", "Randall", 100, 2,  "6");
		Item item7 = new Item(7, "Classic", "Ural", 150, 1,  "7");
		Item item8 = new Item(8, "d2", "D drum", 450, 6,  "8");
		Item item9 = new Item(9, "Blues", "Stadd", 550, 5,  "9");
		Item item10 = new Item(10, "Rocky", "Seinheiser", 80, 20,  "10");
		
		List<Item> items = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10);
		itemRepo.saveAll(items);
		
		Combo combo1 = new Combo("1 2 3", 1);
		Combo combo2 = new Combo("1 5", 2);
		List<Combo> combos = Arrays.asList(combo1,combo2);
		comboRepo.saveAll(combos);
		
		/*Sale sale1 = new Sale("president@usa.gov", 830);
		Sale sale2 = new Sale("president@usa.gov", 330);
		List<Sale> sales = Arrays.asList(sale1,sale2);
		saleRepo.saveAll(sales);
		
		SaleCombo saleCombo1 = new SaleCombo(sale1, combo1);
		saleCombRepo.save(saleCombo1);
		
		SaleItem saleItem1 = new SaleItem(sale1, item1);
		SaleItem saleItem2 = new SaleItem(sale1, item2);
		SaleItem saleItem3 = new SaleItem(sale1, item3);
		SaleItem saleItem4 = new SaleItem(sale2, item3);
		List<SaleItem> saleItems = Arrays.asList(saleItem1,saleItem2,saleItem3,saleItem4);
		saleItemRepo.saveAll(saleItems);*/
		ItemDTO itemdD1 = Item.makeItemDTO(item1);
		ItemDTO itemdD2 = Item.makeItemDTO(item2);
		List<ItemDTO> salesIt1 = Arrays.asList(itemdD1,itemdD2);
		//manager.saveOrder(salesIt1, "president@usa.gov");
		
		System.out.println("*** tests ***");
		List<List<ItemDTO>> test1 = manager.getBestCombos(3);
		//test1.forEach(System.out::println);
		System.out.println("*** tests 2***");
		List<Item> test2 = manager.getBestSellerItems(3);
		//test2.forEach(System.out::println);
		
		
	}



	
}
