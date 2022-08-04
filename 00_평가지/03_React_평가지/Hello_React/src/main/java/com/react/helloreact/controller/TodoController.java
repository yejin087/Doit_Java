package com.react.helloreact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.react.helloreact.model.Todo;
import com.react.helloreact.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@PutMapping("add")
	public void addTodo(@RequestBody Todo todo) {
		todoService.save(todo);
	}

	@GetMapping("list")
	public List<Todo> listTodo() {
		return todoService.findAll();
	}

	@GetMapping("view/{num}")
	public Todo viewTodo(@PathVariable Long num) {
		return todoService.findById(num);
	}

	@PutMapping("update")
	public void updateTodo(@RequestBody Todo todo) {
		todoService.update(todo);
	}

	@DeleteMapping("delete/{num}")
	public void deleteTodo(@PathVariable Long num) {
		todoService.delete(num);
	}

	@GetMapping("search")
	public List<Todo> searchTodo(String searchword) {
		return todoService.search(searchword);
	}
}
