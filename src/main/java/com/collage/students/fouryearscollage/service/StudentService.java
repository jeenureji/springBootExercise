package com.collage.students.fouryearscollage.service;

import com.collage.students.fouryearscollage.dto.StudentDto;
import com.collage.students.fouryearscollage.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudentDetails();
    void createStudent(Student student);

   HashMap<Integer, Optional<Student>> getStudentById(Integer studentId);

    public List<StudentDto> findStudents(Integer id);


}
