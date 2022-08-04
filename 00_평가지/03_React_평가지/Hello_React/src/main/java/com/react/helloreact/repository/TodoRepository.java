package com.react.helloreact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.react.helloreact.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	public List<Todo> findByTitleContainingOrContentContaining(String titlesearch, String contentSearch);
}
