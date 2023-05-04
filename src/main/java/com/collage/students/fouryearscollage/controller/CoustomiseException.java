package com.collage.students.fouryearscollage.controller;

import com.collage.students.fouryearscollage.service.ExceptionResponce;
import com.collage.students.fouryearscollage.service.InvalidUserIdException;
import com.collage.students.fouryearscollage.service.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CoustomiseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleException(ExceptionResponce responce, WebRequest request){
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


}
