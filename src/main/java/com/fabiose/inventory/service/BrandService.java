package com.fabiose.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiose.inventory.domain.Brand;
import com.fabiose.inventory.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	public void save(Brand brand) throws Exception{
		brandRepository.save(brand);
	}
	
	public Iterable<Brand> findAll() throws Exception{
		return brandRepository.findAll();
	}
}
