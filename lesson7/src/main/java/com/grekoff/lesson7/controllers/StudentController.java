package com.grekoff.lesson7.controllers;


import com.grekoff.lesson7.entities.Student;
import com.grekoff.lesson7.services.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public List<Student> showAllStudents(){
        return studentsService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentsService.findById(id);
    }

    @PostMapping
    public Student addNewStudent(@RequestBody Student student){
        student.setId(null);
        return studentsService.save(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentsService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentsService.deleteById(id);
    }
}
