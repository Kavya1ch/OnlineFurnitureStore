package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.repository.UserManagementRepository;
@Service

public class UserManagementService implements UserManagementServiceInterface {

	
	@Autowired
	public UserManagementRepository umd;

	
	@Transactional
	@Override
	public FurnitureUser loginUser(FurnitureUser user) throws UserNotFoundException  {
		Optional<FurnitureUser> optionalUser=umd.findById(user.getUId());
		if(!optionalUser.isEmpty())
		{
			if(optionalUser.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}
	/*if(!optionalUser.isEmpty())
	{
		if(optionalUser.get().getPassword().equals(user.getPassword()))
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException("Wrong Password");
		}
	}
	else
	{
		throw new UserNotFoundException("User Not Found");
	}
}*/

	

	@Transactional
	@Override
	public FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException {
		Optional<FurnitureUser> userTemp = umd.findById(user.getUId());
		try {
			
			if (userTemp != null) {
				user = umd.save(user);
				
				return user;

			} else {

				throw new UserNotFoundException("The given User already exist");
			}
		} catch (Exception e) {
			throw new UserNotFoundException("The given User is  already exist");
		}

	}

	

	@Transactional
	@Override
	public FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException {
		Optional<FurnitureUser> resultUser = umd.findById(user.getUId());
		try {
			
			if ((resultUser != null)) {

				FurnitureUser updateUser = umd.save(user);
				
				return updateUser;

			} else {
				throw new UserNotFoundException("The User is already exist");

			}
		} catch (Exception e) {
			throw new UserNotFoundException("User already exist");
		}

	}

	

	@Transactional
	@Override
	public String deleteUser() throws UserNotFoundException {
		List<FurnitureUser> resultUser = new ArrayList<FurnitureUser>();
		try {
			
			resultUser = umd.findAll();
			if (resultUser != null) {
				umd.deleteAll();
				
				return "Deleted successfully";
			} else {
				throw new UserNotFoundException("There is no values in user table");
			}

		} catch (Exception e) {
			throw new UserNotFoundException("There is no values in the user table");
		}
	}

	
	@Transactional
	@Override
	public FurnitureUser deleteUserById(int uid) throws UserNotFoundException {
		Optional<FurnitureUser> del = umd.findById(uid);
		
		if (del == null) {
			throw new UserNotFoundException("No user found");
		}

		else {
			umd.deleteById(uid);
			if (del.isPresent()) {
				
				return del.get();
			} else {
				throw new UserNotFoundException("Not Present");
			}

		}
	}

	
	@Transactional
	@Override
	public FurnitureUser getId(int uid) throws UserNotFoundException {
		Optional<FurnitureUser> getUser = umd.findById(uid);
		
		if (getUser == null) {
			throw new UserNotFoundException("User not found");
		} else {
			FurnitureUser getUserId = umd.findById(uid).orElse(null);
			
			return getUserId;
		}
	}

}

