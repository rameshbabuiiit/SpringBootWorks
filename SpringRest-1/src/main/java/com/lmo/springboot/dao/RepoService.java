package com.lmo.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmo.springboot.model.User;
import com.lmo.springboot.repos.UserRepository;

@Service
public class RepoService {
	@Autowired
	UserRepository userRepo;

	public void insert(User user) {
		userRepo.save(user);
	}

	public Optional<User> getUser(long id) {
		return userRepo.findById(id);
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUserByEmpname(String userName) {
		return userRepo.getUserByEmpname(userName);
	}

}
