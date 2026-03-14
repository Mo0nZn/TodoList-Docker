package com.kaua.todolist.controller;

import com.kaua.todolist.model.TodoList;
import com.kaua.todolist.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public TodoList createTodo(@RequestBody TodoList todoList) {
        return this.todoRepository.save(todoList);
    }

    @GetMapping
    public List<TodoList> getTodoList() {
        return this.todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> searchById(@PathVariable Long id) {
        if (this.todoRepository.existsById(id)) {
            return ResponseEntity.ok(todoRepository.findById(id).get());
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoList> update(@PathVariable Long id, @RequestBody TodoList todoUpdated) {
        if (this.todoRepository.existsById(id)) {
            TodoList todoList = this.todoRepository.findById(id).get();
            todoList.setDescription(todoUpdated.getDescription());
            todoList.setName(todoUpdated.getName());
            TodoList updatedTodoList = this.todoRepository.save(todoList);
            return ResponseEntity.ok(updatedTodoList);
        }else  {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (this.todoRepository.existsById(id)) {
            this.todoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TodoList> updateStatus(@PathVariable Long id, @RequestBody TodoList updatedTodo) {
        if (this.todoRepository.existsById(id)) {
            TodoList todoList = this.todoRepository.findById(id).get();
            todoList.setStatus(updatedTodo.getStatus());
            TodoList updatedTodoList = this.todoRepository.save(todoList);
            return ResponseEntity.ok(updatedTodoList);
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

}
