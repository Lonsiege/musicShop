package com.epoch.musshop.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epoch.musshop.model.Item;



@Repository

public interface ItemRepository extends CrudRepository<Item, Integer> {
	@Query("Select i from Item i "
			+ " left join SaleItem si on i.id = si.item "
			+ " group by i.id "
			+ " order by count(i) desc "
			+ "   ")
	public Iterable<Item> getByPop();
	
	@Query(value = "SELECT it.* from items it "
			+ " LEFT JOIN salesitems si on it.id = si.item_id "
			+ " group by it.id"
			+ " order by count(*) desc"
			+ " limit 0, :limit ", nativeQuery = true)
	public Iterable<Item> getTopBestSeller(@Param("limit") int limit);
	
	public Item findByCatalog(@Param("catalog") int catalog);
}
