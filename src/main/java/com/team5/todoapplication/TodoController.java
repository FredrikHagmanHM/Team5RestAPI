package com.team5.todoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    TodoRepository tr;

    @Autowired
    public TodoController(TodoRepository tr) {
        this.tr = tr;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {

        System.out.println ("kommer hit!");

        return tr.getTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable String id, HttpServletResponse response) {
        Optional<Todo> todo = tr.getTodo(id);
        if(todo.isPresent()){
            return todo.get();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }

    @PostMapping("/todos")
    public void postTodo(@RequestBody Todo todo) {

        tr.createTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public void putTodo(@PathVariable String id, @RequestBody Todo newTodo) {
        tr.updateTodo(id, newTodo);
    }

    @DeleteMapping("/todos/{id}")
    public void putTodo(@PathVariable String id) {
        tr.deleteTodo(id);
    }

    @DeleteMapping("/todos")
    public void deleteAllTodos() {
        tr.deletAllTodos();
    }
}
