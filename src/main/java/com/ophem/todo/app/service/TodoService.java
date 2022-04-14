package com.ophem.todo.app.service;

import java.util.List;

import com.ophem.todo.app.entity.TodoEntity;

public interface TodoService {

	List<TodoEntity> getAllTodo();
	
	TodoEntity save(TodoEntity todo);
	
	TodoEntity getTodoById(Integer id);
	
	TodoEntity update(TodoEntity todo, Integer id);
	
	void deleteById(Integer id);
	
	
}
