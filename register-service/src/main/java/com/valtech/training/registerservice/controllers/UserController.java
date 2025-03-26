package com.valtech.training.registerservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public UserVO signIn(@RequestBody UserVO vo) {
		return userService.signInUser(vo);
	}
	
	@PostMapping("/subscription/{sid}")
	public void addUserToSubscription(@PathVariable("sid") long id, @RequestBody UserVO vo) {
		userService.addUserToSubscription(vo, id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserVO>  getUserById(@PathVariable("id") long id) {
		try {
			return ResponseEntity.ok(userService.getUserById(id));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.of(Optional.empty());
		}
	}
	
//	@GetMapping("/{id}")
//	public UserVO getUserById(@PathVariable("id") long id) {
//		return userService.getUserById(id);
//	}
	
	@DeleteMapping("/{id}")
	public void deleteUserFromSubscription(@PathVariable("id") long id) {
		userService.deleteUserFromSubscription(id);
	}
	
}
