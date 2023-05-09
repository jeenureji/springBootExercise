package com.collage.students.fouryearscollage.exception;

import com.collage.students.fouryearscollage.service.ExceptionResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CoustomiseException {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleException(StudentNotFoundException exception){
    ExceptionResponce exceptionResponce = new ExceptionResponce();
    exceptionResponce.setDateTime(LocalDateTime.now());
    exceptionResponce.setMessage("Student details not found");
    ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponce, HttpStatus.NOT_FOUND );
    return entity;
    }
    @ExceptionHandler(InvalidUserIdException.class)
    public ResponseEntity<Object> studIdLengthExcep(InvalidUserIdException invalidUserIdException, WebRequest request){
        ExceptionResponce exceptionResponce = new ExceptionResponce();
        exceptionResponce.setDateTime(LocalDateTime.now());
        exceptionResponce.setMessage("invalid id length");
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponce, HttpStatus.NOT_ACCEPTABLE);
        return entity;
}
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> studIdLengthExcep(NumberFormatException exception, WebRequest request){
        ExceptionResponce exceptionResponce = new ExceptionResponce();
        exceptionResponce.setDateTime(LocalDateTime.now());
        exceptionResponce.setMessage("student id NumberFormatException");
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponce, HttpStatus.FORBIDDEN);
        return entity;
    }

    @ExceptionHandler(CollegeNotFoundException.class)
    public ResponseEntity<Object> studIdLengthExcep(CollegeNotFoundException exception, WebRequest request){
        ExceptionResponce exceptionResponce = new ExceptionResponce();
        exceptionResponce.setDateTime(LocalDateTime.now());
        exceptionResponce.setMessage("college not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponce, HttpStatus.FORBIDDEN);
        return entity;
    }
}
