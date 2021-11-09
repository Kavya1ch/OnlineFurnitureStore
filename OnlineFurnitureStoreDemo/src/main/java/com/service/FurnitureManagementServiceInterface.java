package com.service;

import java.util.List;

import com.entity.Furniture;
import com.exception.FurnitureServiceException;

public interface FurnitureManagementServiceInterface {

	List<Furniture> getAllFurnitures() throws FurnitureServiceException;

	Furniture getFurnitureById(long furnitureId) throws FurnitureServiceException;

	Furniture registerFurniture(Furniture furniture) throws FurnitureServiceException;

	Furniture updateFurnitureById(long furnitureId, Furniture furniture) throws FurnitureServiceException;

	String deleteFurniture() throws FurnitureServiceException;

	Furniture deleteFurnitureById(long furnitureId) throws FurnitureServiceException;
}
