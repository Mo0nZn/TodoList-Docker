# TodoList-Docker
Simple todo List API containerized.


# Todo List CRUD API

A simple Todo List API built using **Spring Boot**.  
This project was developed to apply simple concepts about back-end development and **docker**.

The API allows to do simple *CRUD* oprations as: **Create, delete and update**. 

---

# Technologies used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (data base in memory)
- Gradle
- Docker
- 
---

# API Structure

*Each task contains the following fildes*:

- **id**
- **name**
- **description**
- **status**
- **createdDate**

---

# Endpoints

### Create Task

POST /todolist

### Find all tasks 

GET /todolist

### Find Task by ID

GET /todolis/id

### Update Task

PUT /todolist/id

### Update Task Status

PUT /todolist/id/status

### Delete Task

DELETE /todolist/id

---

Body example:

json
{
  "name": "Estudar Docker",
  "description": "Aprender containerização"
}

Status body example:

json
{
  "status": false
}

---

# How excute Docker

- **docker build -t todo-api .**

- docker run -p 8080:8080 todo-api

your API will be avaliable at: http://localhost:8080

your H2 DB will be avaliable at:
http://localhost:8080/h2-console/
