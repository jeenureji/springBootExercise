package com.collage.students.fouryearscollage.service;


import com.collage.students.fouryearscollage.exception.InvalidUserIdException;
import com.collage.students.fouryearscollage.exception.StudentNotFoundException;
import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public HashMap<Integer,Student> getStudentById(Integer studentId) {
        try {
            String stud = String.valueOf(studentId);
            if (stud.length() > 3) {
                throw new InvalidUserIdException();
            }

            Student student = studentRepository.findByStudentId(studentId);
            HashMap<Integer, Student> stu = new HashMap<>();
            stu.put(studentId, student);
            if (stu.get(studentId) == null) {
                logger.info("student id passed is:" + studentId);
                throw new StudentNotFoundException();
            }

            return stu;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }


    }

}