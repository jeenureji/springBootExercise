package com.collage.students.fouryearscollage.service;

import com.collage.students.fouryearscollage.model.College;
import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.CollegeRepository;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollegeServiceImp implements CollegeService {
    public CollegeRepository collegeRepository;
    public StudentRepository studentRepository;


    public CollegeServiceImp(CollegeRepository collegeRepository, StudentRepository studentRepository){
        this.collegeRepository = collegeRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<College> getCollegeStudents() {
        return collegeRepository.findAll();
    }
}
