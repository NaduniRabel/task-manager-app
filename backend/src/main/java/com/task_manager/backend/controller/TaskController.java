package com.task_manager.backend.controller;

import com.task_manager.backend.dto.CreateTaskDto;
import com.task_manager.backend.dto.ListTaskDto;
import com.task_manager.backend.service.interfaces.TaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/task")
public class TaskController {
    
    /*Controller for task operations */
    /*Handles Http requests */
    @Autowired
    private TaskService taskService;
    /*List all tasks */
    @GetMapping("/all")
    public ResponseEntity<List<ListTaskDto>> getAllTasks() {
            List<ListTaskDto> taskList = taskService.getAllTasks();
            return ResponseEntity.ok(taskList);    
    }
    /*Get task by ID */
    @GetMapping("/{id}")
    public ResponseEntity<ListTaskDto> getTaskbyId(@PathVariable Long id) {
            ListTaskDto task = taskService.getTaskbyId(id);
            return ResponseEntity.ok(task);
    }
    /*Create task */
    @PostMapping("/create")
    public ResponseEntity<ListTaskDto> createTask(@Valid @RequestBody CreateTaskDto dto) {
            ListTaskDto task = taskService.createTask(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    /*Update task by ID */
    @PutMapping("/update/{id}")
    public ResponseEntity<ListTaskDto> updateTask(@Valid @PathVariable Long id, @RequestBody CreateTaskDto dto) {
            ListTaskDto task = taskService.updateTask(id, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    /*Delete task by ID */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
    }
    
}
