package com.collage.students.fouryearscollage;


import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import com.collage.students.fouryearscollage.service.StudentService;
import com.collage.students.fouryearscollage.service.StudentServiceImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AllStudentDataTest {

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentServiceImp studentServiceImp;


    public static List<Student> getAllStudentList() throws IOException{
        File file = new File("src/test/resources/allStudents.json");
        ObjectMapper  objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        TypeReference<List<Student>> typeReference = new TypeReference<>() {

        };

        return  objectMapper.readValue(file, typeReference);
    }

    @Test
    public void testAllStudents() throws IOException {
        List<Student> student = getAllStudentList();
        given(studentRepository.findAll()).willReturn(student);
        List<Student> students = studentServiceImp.getAllStudentDetails();
        assertThat(students).isNotNull();
    }
}
