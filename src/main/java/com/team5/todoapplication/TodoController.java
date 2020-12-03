package com.team5.todoapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TodoController {

    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoController() {
        todos.add(new Todo("Buy Milk"));
        todos.add(new Todo("Pay bills"));
        todos.add(new Todo("Call mom"));
        todos.add(new Todo("Get the presents"));
        todos.add(new Todo("Make an MVC application"));
    }

    @GetMapping("/todos")
    public String todos(@RequestParam(value = "mark_as_done", required = false) Integer markAsDone, Model model) {
        if(markAsDone != null) {
            todos.get(markAsDone).changeStatus();
        }
        model.addAttribute("todos", todos);
        return "todos";
    }

}
