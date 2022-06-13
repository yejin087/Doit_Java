package com.react.reactmyjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.react.reactmyjwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

}
