package com.ophem.todo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ophem.todo.app.entity.TodoEntity;
import com.ophem.todo.app.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public List<TodoEntity> getAllTodo() {
		
		return todoRepository.findAll();
	}

	@Override
	public TodoEntity save(TodoEntity todo) {
		return todoRepository.save(todo);
	}

	@Override
	public TodoEntity showById(TodoEntity todo, Integer id) {
		Optional<TodoEntity> existingTodo = todoRepository.findById(id);
		if(existingTodo.isPresent())
			return todoRepository.save(todo);
		else
			System.out.println("oops, todo does not exist");
		return null;
	}

	

}
