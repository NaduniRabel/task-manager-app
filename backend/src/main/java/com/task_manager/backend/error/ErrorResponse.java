package com.task_manager.backend.error;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    /*Error response structure */
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message; 
    private String path;
}
