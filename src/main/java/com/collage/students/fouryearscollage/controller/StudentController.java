package com.collage.students.fouryearscollage.controller;

import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudentDetails() {
        return studentService.getAllStudentDetails();
    }

    @PostMapping("/addStudents")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<HashMap<Integer, Student>> getStudentById(@PathVariable String id) {

        int studentId = Integer.parseInt(id);
        HashMap<Integer, Student> student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);

    }

}
