package com.fabiose.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabiose.inventory.domain.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long>{

}
