package com.collage.students.fouryearscollage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Branch extends JpaRepository<Branch, String> {
    @Override
    List<Branch> findAll();
}
