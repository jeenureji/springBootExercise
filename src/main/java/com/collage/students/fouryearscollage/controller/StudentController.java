package com.collage.students.fouryearscollage.controller;

import com.collage.students.fouryearscollage.dto.StudentDto;
import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.service.StudentService;
import com.collage.students.fouryearscollage.service.StudentServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Slf4j
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

private String version;
private String ui_version;
    @Autowired
    StudentService studentService;
    StudentServiceImp studentServiceImp;
    public StudentController(StudentServiceImp studentServiceImp) throws IOException {
        this.studentServiceImp = studentServiceImp;
        loadProperty();
    }
    private void loadProperty() throws IOException {
        Properties pro = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("content.properties")){
            if(input !=null){
                pro.load(input);
            }
        }
       version = pro.getProperty("version");
        ui_version = pro.getProperty("ui_version");
    }

    @GetMapping("/students/{version}")
    public ResponseEntity<List<Student>> getAllStudentDetails(@PathVariable("version") String requiredVersion) {
        if(!requiredVersion.matches("\\d+")){
            log.error("invalidVersion : {}", requiredVersion );
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!requiredVersion.equals(version)){
            log.error("not equal :{}", requiredVersion);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        List<Student> students = studentService.getAllStudentDetails();

        return new ResponseEntity<>(students, HttpStatus.ACCEPTED);
    }
    @GetMapping("/newStudent")
    public ResponseEntity<String> studentNew() {
        String jsonArray = studentServiceImp.getAllNewStudents();
        if (jsonArray.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(jsonArray);
        }
    }
    @PostMapping("/addStudents")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<HashMap<Integer, Optional<Student>>> getStudentById(@PathVariable String id) {

        int studentId = Integer.parseInt(id);
        HashMap<Integer, Optional<Student>> student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.FOUND);


    }


    @GetMapping("/stu/{id}")
    public ResponseEntity<List<StudentDto>> getAllStudnets(@PathVariable Integer id){
        List<StudentDto> getStudent = studentService.findStudents(id);
        return new ResponseEntity<>(getStudent, HttpStatus.FOUND);
    }

}
