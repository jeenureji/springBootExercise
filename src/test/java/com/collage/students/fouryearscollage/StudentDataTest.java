package com.collage.students.fouryearscollage;

import com.collage.students.fouryearscollage.model.Student;
import com.collage.students.fouryearscollage.repository.StudentRepository;
import com.collage.students.fouryearscollage.service.StudentServiceImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class StudentDataTest {
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentServiceImp studentServiceImp;


    public static HashMap<Integer, Student> studentList() throws IOException {
        File file = new File("src/test/resources/student.json");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        TypeReference<HashMap<Integer, Student>> typeReference = new TypeReference<>() {
        };
        return objectMapper.readValue(file, typeReference);
    }

    @ParameterizedTest
    @MethodSource("provideStudent")
    public void checkStudentDetails(Student student) {
            given(studentRepository.findByStudentId(student.getStudentId())).willReturn(student);
            HashMap<Integer, Student> student3 = studentServiceImp.getStudentById(student.getStudentId());
            Assertions.assertThat(student3).isNotNull();



    }
    private static Stream<Arguments> provideStudent() throws IOException {
            HashMap<Integer, Student> students = studentList();
             return students.values().stream().map(Arguments::of);
    }
}





