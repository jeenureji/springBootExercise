package com.collage.students.fouryearscollage.repository;

import com.collage.students.fouryearscollage.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CollegeRepository extends JpaRepository<College, String> {

    List<College> findAll();

}
