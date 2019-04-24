package com.learnmodeon.users.ui.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnmodeon.users.ui.model.requests.UserDetailsRequestModel;
import com.learnmodeon.users.ui.model.responses.RestUser;

@RestController
@RequestMapping("/users")
public class UserController {
	Map<String,RestUser> users = null;
	@GetMapping
	public String getUsers(
			@RequestParam(value = "page", required = false, defaultValue = "20") String page,
			@RequestParam(value = "limit", required = false) String limit)
	{
		return "Get Users Called with page=" + page + " and limit = " + limit;
	}

	@GetMapping(path = "/{userId}", produces = {
			// add jackson xml to pom
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	// public RestUser getUser(@PathVariable String userId) {
	public ResponseEntity<RestUser> getUser(@PathVariable String userId) {
		
		/*RestUser ruser = new RestUser();
		ruser.setId(123);
		ruser.setName("Ramesh");
		ruser.setDept("Computers");
		ruser.setSalary(100000);
		return new ResponseEntity<RestUser>(ruser, HttpStatus.OK);*/
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = {
			// add jackson xml to pom
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
					// add jackson xml to pom
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RestUser> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		RestUser ruser = new RestUser();
		ruser.setId(userDetails.getId());
		ruser.setName(userDetails.getName());
		ruser.setDept(userDetails.getDept());
		ruser.setSalary(userDetails.getSalary());
		if(users==null) users = new HashMap<>();
		String userId1 = Long.toString(ruser.getId());
		users.put(userId1,ruser);
		return new ResponseEntity<>(users.get(userId1),HttpStatus.OK);
		//return new ResponseEntity<RestUser>(ruser, HttpStatus.OK);
	}

	@PutMapping
	public String updateUser() {
		return "Update User Called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User Called";
	}
}
