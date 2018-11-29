package com.fabiose.inventory.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiose.inventory.domain.OperatingSystem;
import com.fabiose.inventory.dto.OperatingSystemDto;
import com.fabiose.inventory.service.OperatingSystemService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/os")
public class OperatingSystemRest {

	@Autowired
	private OperatingSystemService operatingSystemService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() throws IOException {
		try {
			Iterable<OperatingSystem> operatingSystems = operatingSystemService.findAll();

			List<OperatingSystemDto> operatingSystemsDto = new ArrayList<OperatingSystemDto>();

			operatingSystems.forEach(op -> {
				operatingSystemsDto.add(modelMapper.map(op, OperatingSystemDto.class));
			});

			return ResponseEntity.status(HttpStatus.OK).body(operatingSystemsDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> save(@RequestBody JsonNode operatingSystem) {
		try {
			OperatingSystem os = new OperatingSystem();
			os.setName(operatingSystem.get("name").asText());
			operatingSystemService.save(os);

			return ResponseEntity.status(HttpStatus.OK).body("ok");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
