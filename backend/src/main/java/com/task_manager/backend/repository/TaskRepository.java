package com.task_manager.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task_manager.backend.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{  
    /*Task Repository */
} 
