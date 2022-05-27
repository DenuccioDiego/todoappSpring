package com.todo.todoapp.controllers;

import java.util.List;

import com.todo.todoapp.dto.ToDoDto;
import com.todo.todoapp.services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toDo")
public class ToDoRestController {

    private static Logger logger = LoggerFactory.getLogger(ToDoRestController.class);

    private final ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ToDoDto saveToDo(@RequestBody ToDoDto toDoDto) {
        logger.info("salvataggio task");
        return this.toDoService.saveToDo(toDoDto);
    }

    @GetMapping
    public List<ToDoDto> getAllToDo() {
        logger.info("restuisce tutti i task");
        return this.toDoService.getAllToDo();
    }

    @GetMapping("/{id}")
    public ToDoDto getByIdToDo(@PathVariable("id") Long id) {
        logger.info("restuisce il task per id");
        return this.toDoService.getToDoById(id);
    }

    @GetMapping("/searchWord/{word}")
    public List<ToDoDto> getByWordToDo(@PathVariable("word") String word) {
        logger.info("restuisce il task per parola chiave");
        return this.toDoService.getToDoByText(word);
    }

    @PutMapping("/{id}")
    public ToDoDto editToDo(@PathVariable("id") Long id, @RequestBody ToDoDto toDoDto) {
        logger.info("modifica il task selezionato per id");
        return this.toDoService.editToDo(id, toDoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        logger.info("modifico il task selezionato per id");
        this.toDoService.deleteToDoById(id);
    }
}
