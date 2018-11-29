package com.fabiose.inventory.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiose.inventory.domain.Brand;
import com.fabiose.inventory.domain.Machine;
import com.fabiose.inventory.domain.OperatingSystem;
import com.fabiose.inventory.service.MachineService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/machine")
public class MachineRest {

	@Autowired
	private MachineService machineService;

	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(machineService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> save(@RequestBody JsonNode machine) {
		try {
			Machine m = new Machine();
			m.setSerie(machine.get("serie").asText());
			
			Brand b = new Brand();
			b.setId(machine.get("brand").get("id").asLong());
			
			OperatingSystem os = new OperatingSystem();
			os.setId(machine.get("operatingSystem").get("id").asLong());
			
			m.setBrand(b);
			m.setOperatingSystem(os);
			
			machineService.save(m);
			
			return ResponseEntity.status(HttpStatus.OK).body("ok");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
