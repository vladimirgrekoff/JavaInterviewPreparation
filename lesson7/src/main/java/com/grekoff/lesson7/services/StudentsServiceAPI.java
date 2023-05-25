package com.grekoff.lesson7.services;

import com.grekoff.lesson7.entities.Student;

import java.util.List;

public interface StudentsServiceAPI {

    List<Student> findAllStudents();

    Student findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
}
