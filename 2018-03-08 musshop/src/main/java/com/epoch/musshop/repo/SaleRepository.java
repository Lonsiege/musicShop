package com.epoch.musshop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.musshop.model.Sale;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer> {

}
