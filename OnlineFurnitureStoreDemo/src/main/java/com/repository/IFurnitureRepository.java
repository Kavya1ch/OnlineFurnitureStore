package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Furniture;
@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture, Long> {

	
	@Query("from Furniture f where f.furnitureName = :furnitureName")
	public Furniture findbyName(@Param("furnitureName")String furnitureName);
}

