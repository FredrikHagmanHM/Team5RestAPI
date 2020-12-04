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


    //new todos
    public Todo(String name,int id, String description, String category, boolean done, Date createdAt, Date updatedAt) {
        this.name = name;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.category = category;
        this.id = id;
        this.description = description;
        this.done = done;

    }
    // Update todos
   /* public Todo(String name,int id, String description, String category, boolean done, Date updatedAt) {
        this.name = name;
        this.updatedAt = updatedAt;
        this.category = category;
        this.id = id;
        this.description = description;
        this.done = done;

    }*/

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



    public void setName(String name) {
        this.name = name;
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
    public void setDone(boolean done) {
        this.done = done;
    }
}
