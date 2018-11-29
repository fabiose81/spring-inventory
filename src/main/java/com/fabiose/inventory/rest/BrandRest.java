package com.fabiose.inventory.rest;

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

import com.fabiose.inventory.domain.Brand;
import com.fabiose.inventory.dto.BrandDto;
import com.fabiose.inventory.service.BrandService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/brand")
public class BrandRest {

	@Autowired
	private BrandService brandService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		try {
			Iterable<Brand> brands = brandService.findAll();

			List<BrandDto> brandsDto = new ArrayList<BrandDto>();

			brands.forEach(b -> {
				brandsDto.add(modelMapper.map(b, BrandDto.class));
			});

			return ResponseEntity.status(HttpStatus.OK).body(brandsDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

	@RequestMapping(value = "save", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> save(@RequestBody JsonNode brand) {
		try {
			Brand b = new Brand();
			b.setName(brand.get("name").asText());
			brandService.save(b);
			
			return ResponseEntity.status(HttpStatus.OK).body("ok");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
