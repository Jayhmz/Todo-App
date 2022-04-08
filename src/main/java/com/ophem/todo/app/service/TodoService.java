package com.ophem.todo.app.service;

import java.util.List;

import com.ophem.todo.app.entity.TodoEntity;

public interface TodoService {

	List<TodoEntity> getAllTodo();
	
	TodoEntity save(TodoEntity todo);
	
	TodoEntity showById(TodoEntity todo, Integer id);
}
