package com.codestates.ToDoApp.repository;

import com.codestates.ToDoApp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
