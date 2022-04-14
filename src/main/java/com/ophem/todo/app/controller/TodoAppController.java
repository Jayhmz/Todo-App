package com.ophem.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ophem.todo.app.entity.TodoEntity;
import com.ophem.todo.app.service.TodoService;

@Controller
public class TodoAppController {

	@Autowired
	private TodoService todoservice;

	@GetMapping("/")
	public String getAllTodo(Model model) {

		model.addAttribute("tmodel", new TodoEntity());
		model.addAttribute("todos", todoservice.getAllTodo());

		return "todo";
	}

	@PostMapping("/create-todo")
	public String submitCreateTodo(@ModelAttribute("tmodel") TodoEntity todo) {
		try {
			todoservice.save(todo);
			return "redirect:/";
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@GetMapping("/complete-todo/{id}")
	public String markTodoComplete(@PathVariable("id") Integer id, @ModelAttribute("tmodel") TodoEntity todo) {

		try {
			todoservice.update(todo, id);
			return "redirect:/";
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@GetMapping("delete-todo/{id}")
	public String deleteTodo(@PathVariable("id") Integer id) {
		try {
			todoservice.deleteById(id);
			return "redirect:/";
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
