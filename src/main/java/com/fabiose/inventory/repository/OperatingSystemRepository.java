package com.fabiose.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabiose.inventory.domain.OperatingSystem;

public interface OperatingSystemRepository extends CrudRepository<OperatingSystem, Long>{

}
