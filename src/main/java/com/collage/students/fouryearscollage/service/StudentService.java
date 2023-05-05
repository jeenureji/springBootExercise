package com.collage.students.fouryearscollage.service;

import com.collage.students.fouryearscollage.model.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudentDetails();
    void createStudent(Student student);

   HashMap<Integer, Student> getStudentById(Integer studentId);


}
