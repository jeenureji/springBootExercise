package com.collage.students.fouryearscollage.service;

import com.collage.students.fouryearscollage.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudentDetails();
    Student createStudent(Student student);

    Student getStudentById(Integer studentId);
}
