package com.team5.todoapplication;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TodoController {

    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoController() {

        todos.add(new Todo("Shop groceries", 1, " Milk, Bread, Minced meat", "Grocery", false, new Date(), new Date()));
        todos.add(new Todo("Pay bills", 2, " pay the electic bill", "Economy", false, new Date(), new Date()));
        todos.add(new Todo("Buy aspirin", 3, "2 packages", "Misc", false, new Date(), new Date()));
        todos.add(new Todo("Book the dentist", 4, "Make a reservation for the kids", "Appointments", false, new Date(), new Date()));


    }

    // Get all todos
    @GetMapping("/todos")
    public List<Todo>  getallTodos() {
        return  todos;
    }

    // Get todos by ID
    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable int id, HttpServletResponse response) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return null;
    }


    // Add new todos
    /*@PostMapping("/todos")
    public void  newTodo(String name, String desc, String category) {
        int id = todos.size()+1;
        todos.add(new Todo(name, id, desc, category, false));
        //return null;
    }*/

    // Add new todos
    @PostMapping("/todos")
    public Todo newTodo(@RequestBody Todo todo) {
        int id = todos.size()+1;
        Todo newtodo = new Todo(todo.getName(), id, todo.getDescription(), todo.getCategory(), false, new Date(), new Date());
        todos.add(newtodo);
        return newtodo;
    }

    // Delete todos by ID
    @DeleteMapping("/todos/{id}")
    public List<Todo> deleteTodo(@PathVariable int id, HttpServletResponse response) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todos.remove(todo);
                return todos;
            }
        }
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return null;
    }

    // Update todos
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable int id,@RequestBody Todo todo, HttpServletResponse response) {
        for (Todo todoobj : todos) {
            if (todoobj.getId() == id) {
                todoobj.setDone(todo.getDone());
                todoobj.setName(todo.getName());
                todoobj.setCategory(todo.getCategory());
                todoobj.setDescription(todo.getDescription());
                todoobj.setUpdatedAt(new Date());

                return todoobj;
            }
        }
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return null;
    }
}
