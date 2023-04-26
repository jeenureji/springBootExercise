package com.collage.students.fouryearscollage.controller;

import com.collage.students.fouryearscollage.model.College;
import com.collage.students.fouryearscollage.service.CollegeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollegeController {
    @Autowired
    CollegeServiceImp collegeServiceImp;

    @GetMapping("/college")
    public List<College> getStudentsByCollegeName(){
        return  collegeServiceImp.getCollegeStudents();
    }
}
