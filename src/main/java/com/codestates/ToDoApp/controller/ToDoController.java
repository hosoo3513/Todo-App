package com.codestates.ToDoApp.controller;


import com.codestates.ToDoApp.dto.ToDoDto;
import com.codestates.ToDoApp.entity.ToDo;
import com.codestates.ToDoApp.mapper.ToDoMapper;
import com.codestates.ToDoApp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/")
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoMapper mapper;

    public ToDoController(ToDoService toDoService, ToDoMapper mapper) {
        this.toDoService = toDoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postToDo(@Valid @RequestBody ToDoDto.Post requestBody) {
        ToDo response = toDoService.createToDo(mapper.toDoPostDtoToToDo(requestBody));
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<ToDo>> getToDoList() {
        List<ToDo> all = toDoService.getAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping("{id}")
    public ResponseEntity getToDo(@PathVariable("id") long id) {
        ToDo response = toDoService.readToDo(id);
        return ResponseEntity.ok(response);
    }


    @PatchMapping("{id}")
    public ResponseEntity patchToDo(@PathVariable("id") long id,
                                    @Valid @RequestBody ToDoDto.Patch requestBody) {
        requestBody.setToDoId(id);
        ToDo response = toDoService.updateToDo(mapper.toDoPatchDtoToToDo(requestBody));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping
    public ResponseEntity deleteAll() {
        toDoService.deleteToDoAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("{id}")
    public ResponseEntity deleteToDo(@PathVariable("id") long id) {
        toDoService.deleteToDo(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
