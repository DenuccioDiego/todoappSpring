package com.todo.todoapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.todo.todoapp.model.StateEnum;

public class ToDoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;
    private Date creationDate;
    private Date dueDate;
    private StateEnum state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

}
