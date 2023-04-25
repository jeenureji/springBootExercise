package com.collage.students.fouryearscollage.repository;

import com.collage.students.fouryearscollage.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    List<Student> findAllById(String ids);


}
