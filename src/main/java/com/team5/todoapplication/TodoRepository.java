package com.team5.todoapplication;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {

    TodoMongoRepository tmr;
    TodoRepository(TodoMongoRepository tmr) {
        this.tmr = tmr;
    }

    public void createTodo(Todo todo){
        tmr.insert(todo);
    }

    public List<Todo> getTodos() {

        return tmr.findAll();
    }

    public Optional<Todo> getTodo(String id) {
        Optional<Todo> todo = tmr.findById(id);
        return todo;
    }

    public void updateTodo(String id, Todo todo) {
        Todo oldTodo = getTodo(id).get();

        if(todo.getName() == null) {
            todo.setName(oldTodo.getName());
        }

        todo.id = id;
        tmr.save(todo);
    }

    public void deleteTodo(String id) {
        tmr.deleteById(id);
    }

    public void deletAllTodos() {
        tmr.deleteAll();
    }

}

interface TodoMongoRepository extends MongoRepository<Todo, String>{}