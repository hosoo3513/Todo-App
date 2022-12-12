package com.codestates.ToDoApp.mapper;

import com.codestates.ToDoApp.dto.ToDoDto;
import com.codestates.ToDoApp.entity.ToDo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDo toDoPostDtoToToDo(ToDoDto.Post requestBody);

    ToDo toDoPatchDtoToToDo(ToDoDto.Patch requestBody);

    ToDoDto.Response toDoToToDoResponseDto(ToDo toDo);

    List<ToDoDto.Response> ToDoListToResponseDtos(List<ToDo> toDoList);
}
