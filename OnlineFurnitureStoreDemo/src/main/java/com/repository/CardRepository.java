package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Card;
import com.entity.FurnitureOrder;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}