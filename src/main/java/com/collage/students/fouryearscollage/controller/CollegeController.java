package com.collage.students.fouryearscollage.controller;

import com.collage.students.fouryearscollage.model.College;
import com.collage.students.fouryearscollage.service.CollegeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
public class CollegeController {
    @Autowired
    CollegeServiceImp collegeServiceImp;

    @GetMapping("/college")
    public ResponseEntity<List< College>> getStudentsByCollegeName() throws SQLException {
            List<College> college = collegeServiceImp.getCollegeStudents();
        return new ResponseEntity<>(college, HttpStatus.ACCEPTED);

    }
}
