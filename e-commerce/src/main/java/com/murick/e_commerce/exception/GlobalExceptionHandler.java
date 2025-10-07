package com.murick.e_commerce.exception;
import com.murick.e_commerce.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        ApiResponse response = new ApiResponse().builder()
                .message(exception.getMessage())
                .success(true)
                .status(HttpStatus.BAD_REQUEST)
                .data(null)
                .build();
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
