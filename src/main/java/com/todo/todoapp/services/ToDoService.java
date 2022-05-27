package com.todo.todoapp.services;

import java.util.List;

import com.todo.todoapp.dto.ToDoDto;

public interface ToDoService {

    List<ToDoDto> getAllToDo();

    ToDoDto getToDoById(Long id);

    List<ToDoDto> getToDoByText(String word);

    void deleteToDoById(Long id);

    ToDoDto editToDo(Long id, ToDoDto toDoDto) throws IllegalArgumentException;

    ToDoDto saveToDo(ToDoDto toDoDto) throws IllegalArgumentException;
}
