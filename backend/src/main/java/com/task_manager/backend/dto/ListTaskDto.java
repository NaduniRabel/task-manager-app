package com.task_manager.backend.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListTaskDto {
    /*Dto used to get tasks */
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    
}
