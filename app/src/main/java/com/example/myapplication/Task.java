package com.example.myapplication;

import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date dueDate;
    private boolean isDone;


    // Constructors, getters, setters, and other methods


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Task(String title, String description, boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", isDone=" + isDone +
                '}';
    }


    public void setDone(boolean b) {
    }

    public boolean isDone() {
        return ;
    }
}

