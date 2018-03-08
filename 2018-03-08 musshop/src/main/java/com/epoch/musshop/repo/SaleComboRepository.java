package com.epoch.musshop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.musshop.model.SaleCombo;

@Repository
public interface SaleComboRepository extends CrudRepository<SaleCombo, Integer>{

}
