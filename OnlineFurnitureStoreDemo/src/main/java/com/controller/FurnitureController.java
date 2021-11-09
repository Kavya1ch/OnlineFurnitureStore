package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Furniture;
import com.exception.FurnitureServiceException;
import com.service.FurnitureManagementServiceInterface;

@RestController
@RequestMapping("/api/showFurniture")
public class FurnitureController {

	@Autowired
	private FurnitureManagementServiceInterface furnitureService;

	
	
	@PostMapping(path = "/addfurniture")
	public ResponseEntity<Furniture> createFurniture(@RequestBody Furniture furniture)throws FurnitureServiceException {
		Furniture resultFurniture = furnitureService.registerFurniture(furniture);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}

	
	@DeleteMapping(path = "/deleteFurniture/{furnitureId}")
	public Furniture deleteFurnitureByID(@PathVariable("furnitureId") long furnitureId) throws FurnitureServiceException {

		return furnitureService.deleteFurnitureById(furnitureId);

	}

	
	
	@PutMapping("/updateFurniture/{furnitureId}")
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture)throws FurnitureServiceException {
		
		Furniture resultFurniture = furnitureService.updateFurnitureById(furniture.getFurnitureId(), furniture);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}

	
	
	@GetMapping(path = "/getAllFurnitureDetails")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws FurnitureServiceException {
		
		List<Furniture> resultFurniture = furnitureService.getAllFurnitures();
		return new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);

	}

	

	@GetMapping(path = "/getFurnitureDetalis/{furnitureId}")
	public ResponseEntity<Furniture> getFurnitureDetails(@PathVariable("furnitureId") long furnitureId)throws FurnitureServiceException {
		
		Furniture resultFurniture = furnitureService.getFurnitureById(furnitureId);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);

	}

	
	
	@DeleteMapping(path = "/deleteAllFurniture")
	public String deleteAllFurniture() throws FurnitureServiceException {
		
		return furnitureService.deleteFurniture();
	}
}

