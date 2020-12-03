package com.team5.todoapplication;

import java.util.Date;

public class Todo {
    private String name;
    private Date createdAt;
    private boolean done;

    public Todo(String name) {
        this.name = name;
        createdAt = new Date();
        done = false;
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
