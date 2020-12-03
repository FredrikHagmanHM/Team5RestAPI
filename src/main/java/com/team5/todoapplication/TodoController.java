package com.team5.todoapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoController() {
        /*todos.add(new Todo("Buy Milk"));
        todos.add(new Todo("Pay bills"));
        todos.add(new Todo("Call mom"));
        todos.add(new Todo("Get the presents"));
        todos.add(new Todo("Make an MVC application"));*/
        todos.add(new Todo("Shop groceries", 1, " Milk, Bread, Minced meat", "Grocery", true));
        todos.add(new Todo("Pay bills", 2, " pay the electic bill", "Economy", true));
        todos.add(new Todo("Buy aspirin", 3, "2 packages", "Misc", true));
        todos.add(new Todo("Book the dentist", 4, "Make a reservation for the kids", "Appointments", true));


    }

    @GetMapping("/todos1")
    public String todos(@RequestParam(value = "mark_as_done", required = false) Integer markAsDone) {
        if (markAsDone != null) {
            todos.get(markAsDone).changeStatus();
        }
        // model.addAttribute("todos", todos);
        return "";
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable int id) {

        for (Todo todo : todos) {
            if (todo.getId() == id) {

                return todo;
            }

        }
        return null;
    }

    @GetMapping("/todos")
    public List<Todo>  getallTodos() {
        return  todos;
    }

    @PostMapping("/newTodo")
    public void  newTodo(String name, int id, String desc, String category) {
        todos.add(new Todo(name, id, desc, category, true));
        //return null;
    }
}
