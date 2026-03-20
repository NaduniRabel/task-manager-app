package com.task_manager.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto {
    /*Dto used for create and update tasks with validations */
    @NotBlank(message="Title is required")
    @Size(max=50, message="Title must not exceed 50 characters")
    private String title;
    @Size(max=300, message="Description must not exceed 300 characters")
    private String description;
    private String status;
}
