package com.grekoff.lesson7.repositories;


import com.grekoff.lesson7.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository <Student, Long>{
    List<Student> findAll();
}
