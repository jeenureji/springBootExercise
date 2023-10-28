package com.collage.students.fouryearscollage.repository;

import com.collage.students.fouryearscollage.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer>{

    @Override
    List<Student> findAll();

    @Transactional
    Optional<Student> findByStudentId(Integer studentId);



}
