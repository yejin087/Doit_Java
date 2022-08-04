package com.react.helloreact.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.helloreact.model.Todo;
import com.react.helloreact.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public void save(Todo todo) {
		todoRepository.save(todo);
	}

	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo findById(Long num) {
		return todoRepository.findById(num).get();
	}

	@Transactional
	public void update(Todo todo) {
		Todo persist = todoRepository.findById(todo.getNum()).get();
		persist.setTitle(todo.getTitle());
		persist.setContent(todo.getContent());
	}

	public void delete(Long num) {
		todoRepository.deleteById(num);
	}

	public List<Todo> search(String searchword) {
		return todoRepository.findByTitleContainingOrContentContaining(searchword, searchword);
	}
}
