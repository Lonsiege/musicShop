package com.epoch.musshop.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epoch.musshop.model.Combo;

@Repository
public interface ComboRepository extends CrudRepository<Combo, Integer> {
	@Query(value = "SELECT * from combo cmb "
			+ " order by counter desc"
			+ " limit 0, :limit ", nativeQuery = true)
	public Iterable<Combo> getTopCombos(@Param("limit") int limit);

	public Combo findByCombine(String comboId);
}
