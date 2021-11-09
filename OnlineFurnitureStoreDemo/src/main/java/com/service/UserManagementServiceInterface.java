package com.service;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;

public interface UserManagementServiceInterface {
	
	FurnitureUser loginUser(FurnitureUser user) throws UserNotFoundException;
	FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException;
	FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException;
	String deleteUser() throws UserNotFoundException;
	FurnitureUser deleteUserById(int uid) throws UserNotFoundException;
	FurnitureUser getId(int uid) throws UserNotFoundException;
}
