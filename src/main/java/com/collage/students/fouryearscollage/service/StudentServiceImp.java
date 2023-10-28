package com.collage.students.fouryearscollage.service;


import com.collage.students.fouryearscollage.dto.StudentDto;
import com.collage.students.fouryearscollage.exception.InvalidUserIdException;
import com.collage.students.fouryearscollage.exception.StudentNotFoundException;
import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class StudentServiceImp implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);
    @Autowired
    StudentRepository studentRepository;



    public List<Student> getAllStudentDetails() {
        List<Student> students = studentRepository.findAll();
        for(Student student: students) {
            if (student.getStudent_subject() == null) {
                String stu = student.getStudentName();
//        if(stu.equals("jeenu")){
//            student.setStudent_subject("html");
//        } else if (stu.equals("jhon")) {
//            student.setStudent_subject("java");
//        }
                switch (stu) {
                    case "jeenu":
                        student.setStudent_subject("java");
                    break;
                    case "jhon":
                        student.setStudent_subject("python");
                    break;
                    case "ram":
                        student.setStudent_subject("html");
                    break;
                    default:
                        throw new StudentNotFoundException();

                }
            }
        }
        return students;
    }

    @Override
    public void createStudent(Student student) {

    }
    public StudentDto getAllStudents(Student student){
        return StudentDto.builder().student_subject(student.getStudent_subject())
                .studentBranch(student.getStudentBranch()).studentCollege(student.getStudentCollege())
                .studentName(student.getStudentName()).studentId(student.getStudentId())
                .college(student.getCollege()).build();

    }
    public String getAllNewStudents() {
        List<Student> student = studentRepository.findAll();
        JSONArray result = new JSONArray();
        if (!student.isEmpty()) {
            log.info("student details: " + student);

            boolean studentNew = true;

            for (Student student1 : student) {
                JSONObject stu = new JSONObject();
//                stu.put("studentId", student1.getStudentId());
//                stu.put("student_and_Branch", student1.getStudentBranch());
//                stu.put("student_and_College", student1.getStudentCollege());
//                stu.put("student_and_Name", student1.getStudentName());
//                stu.put("student_subject", student1.getStudent_subject());

                stu.put("student_new", studentNew);
                result.put(stu);

                studentNew = !studentNew;
            }
        }
return result.toString();
    }
    public List<StudentDto> findStudents(Integer stuId){
        List<StudentDto> studentDtos = new ArrayList<>();
         studentRepository.findByStudentId(stuId).ifPresentOrElse(a -> {
             if(a.getStudentName().equals("jeenu")) {
                 String student = a.getStudentName();
                 switch (student) {
                     case "jeenu":
                         a.setStudentName("jeenu reji");
                         break;
                 }
             }
             studentDtos.add(getAllStudents(a));
         }, () -> {
          boolean studentDto = studentRepository.findByStudentId(stuId).isEmpty();
          if(studentDto){
              log.info("wrong stidentId: " + stuId);
              throw new StudentNotFoundException();
          }
         });

              return studentDtos;

    }

    @Override
    public HashMap<Integer, Optional<Student>> getStudentById(Integer studentId) {
        try {
            String stud = String.valueOf(studentId);
            if (stud.length() > 3) {
                throw new InvalidUserIdException();
            }

           Optional<Student> student = studentRepository.findByStudentId(studentId);
            HashMap<Integer, Optional<Student>> stu = new HashMap<>();
            stu.put(studentId, student);
            if (stu.get(studentId).isEmpty()) {
                logger.info("student id passed is:" + studentId);
                throw new StudentNotFoundException();
            }
//            for(Map.Entry<Integer, Student> entry : stu.entrySet()) {
//                Integer hj = entry.getKey();
//                Student sj = entry.getValue();
//                if (hj != null) {
//                   if (Objects.equals(sj.getStudentName(), "jeenu")) {
//                        sj.setStudentName("jeenu reji");
//
//                    }
//                }
//            }

            return stu;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }


    }

}