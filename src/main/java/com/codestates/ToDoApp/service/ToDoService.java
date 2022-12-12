package com.codestates.ToDoApp.service;

import com.codestates.ToDoApp.entity.ToDo;
import com.codestates.ToDoApp.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAll() {
        List<ToDo> all = toDoRepository.findAll();
        return all;
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo updateToDo(ToDo toDo) {
        ToDo findToDo = findVerifiedToDo(toDo.getId());

        Optional.ofNullable(toDo.getTitle())
                .ifPresent(title -> findToDo.setTitle(title));
        Optional.ofNullable(toDo.getOrder())
                .ifPresent(order -> findToDo.setOrder(order));
        Optional.ofNullable(toDo.isCompleted())
                .ifPresent(completed -> findToDo.setCompleted(completed));

        return toDoRepository.save(findToDo);
    }

    public ToDo readToDo(long toDoId) {
        return findVerifiedToDo(toDoId);
    }

    public void deleteToDo(long toDoId) {
        ToDo verifiedToDo = findVerifiedToDo(toDoId);

        toDoRepository.delete(verifiedToDo);
    }

    public void deleteToDoAll() {
        toDoRepository.deleteAll();
    }

    public ToDo findVerifiedToDo(long toDoId) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(toDoId);
        ToDo toDo = optionalToDo.get();
        return toDo;
    }


}
