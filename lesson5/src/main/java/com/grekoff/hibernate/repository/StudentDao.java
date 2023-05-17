package com.grekoff.hibernate.repository;

import com.grekoff.hibernate.entity.Student;

import java.util.List;

public interface StudentDao {
    Student findById(Long id);

    Student findByName(String name);

    List<Student> findAll();

    void deleteById(Long id);

    Student saveOrUpdate(Student student);

    Student save(Student student);

    Student update(Student student);
}
