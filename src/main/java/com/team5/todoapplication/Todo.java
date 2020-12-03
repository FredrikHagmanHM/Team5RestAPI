package com.team5.todoapplication;

import java.util.Date;

public class Todo {
    private String name;
    private int id;
    private boolean done;
    private String category;
    private String description;
    private Date updatedAt;
    private Date createdAt;


    //new todo
    public Todo(String name, int Id, String description, String category, boolean newTodo) {
        this.name = name;
        if (newTodo ==true){
            this.createdAt = new Date();
        }
        this.updatedAt = new Date();

        done = false;
        this.category = category;
        this.id = Id;
        this.description = description;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public void changeStatus() {
        done = !done;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean getDone() {
        return done;
    }
}
