package com.lmo.springboot.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmo.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> getUserByEmpname(String userName);

}
