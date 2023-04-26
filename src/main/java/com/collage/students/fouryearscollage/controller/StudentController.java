package com.collage.students.fouryearscollage.controller;

import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }
    @PostMapping("/addStudents")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
}
