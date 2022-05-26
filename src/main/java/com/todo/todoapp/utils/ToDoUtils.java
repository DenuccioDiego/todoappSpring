package com.todo.todoapp.utils;

import com.todo.todoapp.dto.ToDoDto;
import com.todo.todoapp.model.entities.ToDo;

public class ToDoUtils {
    public static ToDoDto fromEntityToDTO(ToDo toDoEntity) {

        ToDoDto dto = new ToDoDto();

        dto.setId(toDoEntity.getId());
        dto.setText(toDoEntity.getText());
        dto.setCreationDate(toDoEntity.getCreationDate());
        dto.setDueDate(toDoEntity.getDueDate());
        dto.setState(toDoEntity.getState());

        return dto;
    }

    public static ToDo fromDTOtoEntity(ToDoDto toDoDto) {

        ToDo dvo = new ToDo();

        dvo.setId(toDoDto.getId());
        dvo.setText(toDoDto.getText());
        dvo.setCreationDate(toDoDto.getCreationDate());
        dvo.setDueDate(toDoDto.getDueDate());
        dvo.setState(toDoDto.getState());

        return dvo;
    }

}
