package com.fabiose.inventory.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class MachineDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String serie;
	
	@JsonBackReference
	private BrandDto brand;
	
	@JsonBackReference
	private OperatingSystemDto operatingSystem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public BrandDto getBrand() {
		return brand;
	}
	public void setBrand(BrandDto brand) {
		this.brand = brand;
	}
	public OperatingSystemDto getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(OperatingSystemDto operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
