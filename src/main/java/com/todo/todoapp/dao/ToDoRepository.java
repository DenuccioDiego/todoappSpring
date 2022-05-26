package com.todo.todoapp.dao;

import java.util.List;

import com.todo.todoapp.model.entities.ToDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    @Query("select td from ToDo td where td.text like %:word%")
    List<ToDo> findByWordContaining(@Param("word") String word);

}
