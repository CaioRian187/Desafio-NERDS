package com.DesafioNERDS.Patrimonios.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.DesafioNERDS.Patrimonios.exceptions.DuplicateException;
import com.DesafioNERDS.Patrimonios.exceptions.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> NotFoundExceptionHandler(NotFoundException exception){
        ErrorMessage response = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        ErrorMessage response = new ErrorMessage(HttpStatus.BAD_REQUEST, "Erro de validação, você deixou algum campo obrigatório vazio");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorMessage> DuplicateExceptionHandler(DuplicateException exception){
        ErrorMessage response = new ErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
