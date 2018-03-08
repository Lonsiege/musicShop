package com.epoch.musshop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.musshop.model.SaleItem;

@Repository
public interface SaleItemRepository extends CrudRepository<SaleItem, Integer> {

}
