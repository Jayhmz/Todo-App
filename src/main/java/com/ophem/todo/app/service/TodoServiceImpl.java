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
	public TodoEntity getTodoById(Integer id) {
		Optional<TodoEntity> existingtodo = todoRepository.findById(id);
		if(existingtodo.isPresent()) {
			return todoRepository.getById(id);
		}else {
			return null;
		}
		
	}

	@Override
	public TodoEntity update(TodoEntity todo, Integer id) {
		
		TodoEntity existingTodo = todoRepository.getById(id);
		
		if(!existingTodo.equals(null)) {
			todo.setTitle(existingTodo.getTitle());
			todo.setBody(existingTodo.getBody());
			todo.setCompleted(true);
			return todoRepository.save(todo);
		}else {
			return null;
		}
		
		
	}

	@Override
	public void deleteById(Integer id) {
		Optional<TodoEntity> todoId = todoRepository.findById(id);
		if (todoId.isPresent()) {
			todoRepository.deleteById(id);
		} else {
			System.out.println("unable to fetch todo id");
		}
	}


}
