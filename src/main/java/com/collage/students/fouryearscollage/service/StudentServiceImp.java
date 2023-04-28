package com.collage.students.fouryearscollage.service;

import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getAllStudentDetails() {

        return studentRepository.findAll();

    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public Student createStudent(Student stu) {
        return studentRepository.save(stu);
    }
}