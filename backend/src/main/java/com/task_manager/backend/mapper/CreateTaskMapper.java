package com.task_manager.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.task_manager.backend.dto.CreateTaskDto;
import com.task_manager.backend.entity.Task;

@Mapper(componentModel = "spring") 
public interface CreateTaskMapper {
    /*Create and update dto mapper */
    /*Omitted fields (id, createdAt) are ignored */
    @Mapping(target="id", ignore=true)
    @Mapping(target="createdAt", ignore=true)
    Task toEntity(CreateTaskDto dto);
    
}
