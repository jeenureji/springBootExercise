package com.collage.students.fouryearscollage.repository;

import com.collage.students.fouryearscollage.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer>{

    @Transactional
    Student findByStudentId(Integer studentId);


}
