package com.todo.todoapp.services;

import java.util.List;

import com.todo.todoapp.dto.ToDoDto;

public interface ToDoService {

    List<ToDoDto> getAllToDo();

    ToDoDto getToDoById(Long id);

    List<ToDoDto> getToDoByText(String word);

    String deleteToDoById(Long id);

    ToDoDto editToDo(Long id, ToDoDto toDoDto);

    ToDoDto saveToDo(ToDoDto toDoDto);
}
