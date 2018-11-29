package com.fabiose.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiose.inventory.domain.Machine;
import com.fabiose.inventory.repository.MachineRepository;

@Service
public class MachineService {

	@Autowired
	private MachineRepository machineRepository;
	
	public void save(Machine machine) throws Exception{
		machineRepository.save(machine);
	}
	
	public Iterable<Machine> findAll() throws Exception{
		return machineRepository.findAll();
	}
	
}
