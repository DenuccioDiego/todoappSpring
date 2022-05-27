package com.todo.todoapp.controllers;

import java.util.List;

import com.todo.todoapp.dto.ToDoDto;
import com.todo.todoapp.services.ToDoService;

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

    // private static final Logger logger =
    // LoggerFactory.getLogger(ToDoRestController.class);

    private final ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ToDoDto saveToDo(@RequestBody ToDoDto toDoDto) {
        return this.toDoService.saveToDo(toDoDto);
    }

    @GetMapping
    public List<ToDoDto> getAllToDo() {
        return this.toDoService.getAllToDo();
    }

    @GetMapping("/{id}")
    public ToDoDto getByIdToDo(@PathVariable("id") Long id) {
        return this.toDoService.getToDoById(id);
    }

    @GetMapping("/searchWord/{word}")
    public List<ToDoDto> getByWordToDo(@PathVariable("word") String word) {
        return this.toDoService.getToDoByText(word);
    }

    @PutMapping("/{id}")
    public ToDoDto editToDo(@PathVariable("id") Long id, @RequestBody ToDoDto toDoDto) {
        return this.toDoService.editToDo(id, toDoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        this.toDoService.deleteToDoById(id);
    }
}
