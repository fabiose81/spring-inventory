package com.fabiose.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fabiose.inventory.domain.Brand;
import com.fabiose.inventory.domain.Machine;

public interface MachineRepository extends CrudRepository<Machine, Long>{
	
	List<Machine> findByBrand(Brand brand);

}
