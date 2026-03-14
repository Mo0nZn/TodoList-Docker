package com.kaua.todolist.model;

import jakarta.persistence.*;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean status;
    private LocalDateTime date;

    public TodoList(Long id, String name, String description, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = false;
        this.date = date;
    }

    public TodoList() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @PrePersist
    public void setCreationDate() {
        this.date = LocalDateTime.now();
    }

}
