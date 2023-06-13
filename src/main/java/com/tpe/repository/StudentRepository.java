package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    List<Student> findAll();

    Optional<Student> findById(Long id);

    void delete(Long id);
}
