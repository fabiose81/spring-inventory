package com.fabiose.inventory.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class BrandDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	@JsonManagedReference
	private List<MachineDto> machines;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MachineDto> getMachines() {
		return machines;
	}
	public void setMachines(List<MachineDto> machines) {
		this.machines = machines;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
