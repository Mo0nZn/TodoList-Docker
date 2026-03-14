package com.kaua.todolist.repository;

import com.kaua.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoList, Long>{

}
