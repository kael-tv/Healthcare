package com.example.patients.exception;

import com.example.patients.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //This class handles exceptions
public class GlobalExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex) {

                ApiResponse<Void> response = ApiResponse.<Void>builder()
                        .status(404)
                        .success(false)
                        .message(ex.getMessage())
                        .data(null)
                        .build();

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        @ExceptionHandler(Exception.class) // handles unexpected errors not caught by specific exception handlers
        public ResponseEntity<ApiResponse<Void>> handleGeneric(Exception ex) {

                ApiResponse<Void> response = ApiResponse.<Void>builder()
                        .status(500)
                        .success(false)
                        .message("Internal server error")
                        .data(null)
                        .build();

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)//500 error code
                        .body(response);
        }
}