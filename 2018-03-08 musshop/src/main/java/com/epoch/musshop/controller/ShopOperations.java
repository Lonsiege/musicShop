package com.epoch.musshop.controller;

import java.util.*;

import com.epoch.musshop.common.CommonDTO;
import com.epoch.musshop.common.ItemDTO;
import com.epoch.musshop.model.*;


public interface ShopOperations {
	public List<Item> getItemsByPop();
	public CommonDTO saveOrder(Map<String, Object> params);
	public List<Item> getBestSellerItems(int limit);
	public List<List<ItemDTO>> getBestCombos(int limit); 
	public List<Item> getAllByCatalog(List<Integer> list);
}
