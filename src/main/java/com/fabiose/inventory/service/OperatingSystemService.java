package com.fabiose.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiose.inventory.domain.OperatingSystem;
import com.fabiose.inventory.repository.OperatingSystemRepository;

@Service
public class OperatingSystemService {

	@Autowired
	private OperatingSystemRepository operatingSystemRepository;
	
	public void save(OperatingSystem operatingSystem) throws Exception{
		operatingSystemRepository.save(operatingSystem);
	}
	
	public Iterable<OperatingSystem> findAll() throws Exception{
		return operatingSystemRepository.findAll();
	}
	
}
