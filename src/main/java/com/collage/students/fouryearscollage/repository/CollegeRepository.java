package com.collage.students.fouryearscollage.repository;

import com.collage.students.fouryearscollage.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, String> {
    @Override
    List<College> findAll();
}
