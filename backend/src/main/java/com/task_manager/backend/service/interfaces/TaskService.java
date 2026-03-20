package com.task_manager.backend.service.interfaces;

import java.util.List;

import com.task_manager.backend.dto.CreateTaskDto;
import com.task_manager.backend.dto.ListTaskDto;

public interface TaskService {
    /*Task Service interface */
    List<ListTaskDto> getAllTasks();
    ListTaskDto getTaskbyId(Long id);
    ListTaskDto createTask (CreateTaskDto dto);
    ListTaskDto updateTask (Long id, CreateTaskDto dto);
    Void deleteTask(Long id);    
}
