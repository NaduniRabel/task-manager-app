package com.task_manager.backend.mapper;

import org.mapstruct.Mapper;
import com.task_manager.backend.dto.ListTaskDto;
import com.task_manager.backend.entity.Task;
import java.util.List;

@Mapper(componentModel = "spring") 
public interface ListTaskMapper {
    /*List task dto mapper */
    ListTaskDto toDto(Task task);
    List<ListTaskDto> toDtoList(List<Task> tasks);
    
} 
