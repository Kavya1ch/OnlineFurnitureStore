package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.service.UserManagementServiceInterface;

@RestController
@RequestMapping("/api/UserManagement")
public class UserManagementController {

	@Autowired
	public UserManagementServiceInterface umsd;

	
	
	@PutMapping(path = "/updateUser")
	public ResponseEntity<FurnitureUser> updateUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		FurnitureUser user1 = umsd.updateUser(user);
		return new ResponseEntity<FurnitureUser>(user1, HttpStatus.OK);
	}

	
	
	@PostMapping(path = "/registerUser")
	public ResponseEntity<FurnitureUser> registerUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		FurnitureUser user2 = umsd.registerNewUser(user);
		return new ResponseEntity<FurnitureUser>(user2, HttpStatus.OK);

	}
	
	
	@DeleteMapping(path = "/deleteUserById/{uid}")
	public ResponseEntity<FurnitureUser> deleteUserById(@PathVariable int uid) throws UserNotFoundException {
		
		FurnitureUser user4 = umsd.deleteUserById(uid);
		return new ResponseEntity<FurnitureUser>(user4, HttpStatus.OK);
	
	}

	
	
	@DeleteMapping(path = "/deleteUser")
	public String deleteUser() throws UserNotFoundException {
		
		String user5 = umsd.deleteUser();
		return "Deletion Completed For" + user5;
		
	}
	
	@PostMapping(path = "/loginUser")
	public ResponseEntity<FurnitureUser> loginUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		FurnitureUser user3 = umsd.loginUser(user);
		return new ResponseEntity<FurnitureUser>(user3, HttpStatus.OK);
	}

	

	
	
	/*@PatchMapping(path = "/login")
	public String loginUser(@RequestParam String username, String password) throws UserNotFoundException {
		
		umsd.loginUser(username, password);
		return "Login Successful!!!";
	}*/

	
	
	@GetMapping("/getUser/{uid}")
	public ResponseEntity<FurnitureUser> getId(@PathVariable int uid) throws UserNotFoundException {
		
		FurnitureUser resultuser = umsd.getId(uid);
		return new ResponseEntity<FurnitureUser>(resultuser, HttpStatus.OK);
		
	}

}

