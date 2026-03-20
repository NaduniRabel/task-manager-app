package com.task_manager.backend.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task_manager.backend.dto.CreateTaskDto;
import com.task_manager.backend.dto.ListTaskDto;
import com.task_manager.backend.entity.Task;
import com.task_manager.backend.error.exceptions.ResourceNotFoundException;
import com.task_manager.backend.mapper.CreateTaskMapper;
import com.task_manager.backend.mapper.ListTaskMapper;
import com.task_manager.backend.repository.TaskRepository;
import com.task_manager.backend.service.interfaces.TaskService;


@Service
public class TaskServiceImp implements TaskService {
    /*Implementation of the task service interface */
    /*Handles application logic */
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ListTaskMapper listTaskMapper;
    @Autowired
    private CreateTaskMapper createTaskMapper;
    /*Get all tasks */
    @Override
    public List<ListTaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return listTaskMapper.toDtoList(tasks);
    }
    /*Get specified task */
    @Override
    public ListTaskDto getTaskbyId(Long id) {
       Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
       return listTaskMapper.toDto(task);
    }
    /*Create task */
    @Override
    public ListTaskDto createTask(CreateTaskDto dto) {
        Task task = createTaskMapper.toEntity(dto);
        Task createdTask = taskRepository.save(task);
        return listTaskMapper.toDto(createdTask);
    }
    /*Update specified task */
    @Override
    public ListTaskDto updateTask(Long id, CreateTaskDto dto) {
       Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
       task.setTitle(dto.getTitle());
       task.setDescription(dto.getDescription());
       task.setStatus(dto.getStatus());

       Task updatedTask = taskRepository.save(task);
       return listTaskMapper.toDto(updatedTask);
    }
    /*Delete specified task */
    @Override
    public Void deleteTask(Long id) {
       if(!taskRepository.existsById(id))
        throw new ResourceNotFoundException("Task not found with id: " + id);
       
       taskRepository.deleteById(id);
       return null;
    }   
}
