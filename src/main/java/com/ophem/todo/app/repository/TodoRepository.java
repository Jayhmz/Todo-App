package com.ophem.todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ophem.todo.app.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

}
