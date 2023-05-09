package com.collage.students.fouryearscollage.service;

import com.collage.students.fouryearscollage.exception.CollegeNotFoundException;
import com.collage.students.fouryearscollage.model.College;
import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.CollegeRepository;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
        try {
            List<College> colleges = collegeRepository.findAll();
            return colleges;

        }catch (CollegeNotFoundException e){
            throw new CollegeNotFoundException();
        }
    }
}