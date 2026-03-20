package com.task_manager.backend.error.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    /*Custo exception class */
    public ResourceNotFoundException(String message){
        super(message);
    }
    
}
