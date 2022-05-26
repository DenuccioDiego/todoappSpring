package com.todo.todoapp.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.todo.todoapp.model.StateEnum;

@Entity
@Table(name = "todo")
public class ToDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "text", columnDefinition = "VARCHAR(40)", nullable = false, unique = false)
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_creation", nullable = false, unique = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_due", nullable = false, unique = false)
    private Date dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false, unique = false)
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
