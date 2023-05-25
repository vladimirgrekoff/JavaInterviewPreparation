package com.grekoff.lesson7.services;

import com.grekoff.lesson7.entities.Student;
import com.grekoff.lesson7.repositories.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService implements StudentsServiceAPI{
    private final StudentsRepository studentsRepository;


    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    public Student findById(Long id) {
        return studentsRepository.findById(id).get();
    }

    public Student save(Student student) {
        return studentsRepository.save(student);
    }

    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }
}
