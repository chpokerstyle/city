package com.volokitin.city.exceptions;

import com.volokitin.city.exceptions.custom.CarNotFoundException;
import com.volokitin.city.exceptions.custom.HomeNotFoundException;
import com.volokitin.city.exceptions.custom.PersonNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> catchCarNotFoundException(CarNotFoundException e){
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorInfo(HttpStatus.NOT_FOUND.value(), " Автомобиль не найден "), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> catchHomeNotFoundException(HomeNotFoundException e){
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorInfo(HttpStatus.NOT_FOUND.value(), " Адрес не найден "), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> catchPersonNotFoundException(PersonNotFoundException e){
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorInfo(HttpStatus.NOT_FOUND.value(), " Пользователь не найден "), HttpStatus.NOT_FOUND);
    }
}
