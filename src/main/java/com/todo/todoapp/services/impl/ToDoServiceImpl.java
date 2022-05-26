package com.todo.todoapp.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.todo.todoapp.dao.ToDoRepository;
import com.todo.todoapp.dto.ToDoDto;
import com.todo.todoapp.model.entities.ToDo;
import com.todo.todoapp.services.ToDoService;
import com.todo.todoapp.utils.ToDoUtils;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ToDoDto saveToDo(ToDoDto toDoDto) {

        Date date = new Date();
        toDoDto.setCreationDate(date);

        if (toDoDto.getDueDate() == null) {

            Date sevenDay = new Date(System.currentTimeMillis() + 7L * 24 * 3600 * 1000);
            toDoDto.setDueDate(sevenDay);
        }

        ToDo toDo = ToDoUtils.fromDTOtoEntity(toDoDto);

        toDoRepository.save(toDo);

        return toDoDto;
    }

    @Override
    @Transactional(propagation = Propagation.NEVER, readOnly = true)
    public List<ToDoDto> getAllToDo() {

        List<ToDo> listToDo = this.toDoRepository.findAll();

        List<ToDoDto> listToDoDto = listToDo.stream().map(td -> ToDoUtils.fromEntityToDTO(td))
                .collect(Collectors.toList());

        return listToDoDto;
    }

    @Override
    @Transactional(propagation = Propagation.NEVER, readOnly = true)
    public ToDoDto getToDoById(Long id) {

        ToDo toDo = this.toDoRepository.findById(id).get();
        ToDoDto toDoDto = ToDoUtils.fromEntityToDTO(toDo);

        return toDoDto;
    }

    @Override
    @Transactional(propagation = Propagation.NEVER, readOnly = true)
    public List<ToDoDto> getToDoByText(String word) {

        List<ToDo> listToDo = this.toDoRepository.findByWordContaining(word);
        List<ToDoDto> listToDoDto = listToDo.stream().map(td -> ToDoUtils.fromEntityToDTO(td))
                .collect(Collectors.toList());

        return listToDoDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ToDoDto editToDo(Long id, ToDoDto toDoDto) {

        Date date = new Date();
        toDoDto.setCreationDate(date);

        if (toDoDto.getDueDate() == null) {

            Date sevenDay = new Date(System.currentTimeMillis() + 7L * 24 * 3600 * 1000);
            toDoDto.setDueDate(sevenDay);
        }

        ToDo toDo = ToDoUtils.fromDTOtoEntity(toDoDto);
        this.toDoRepository.saveAndFlush(toDo);

        return toDoDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String deleteToDoById(Long id) {

        this.toDoRepository.deleteById(id);

        return "Task cancellata";
    }

}
