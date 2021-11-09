package com.repository;

import org.springframework.stereotype.Repository;

import com.entity.FurnitureUser;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserManagementRepository extends JpaRepository<FurnitureUser, Integer> {

}
