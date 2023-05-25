package com.grekoff.lesson7.controllers;


import com.grekoff.lesson7.converters.StudentConverter;
import com.grekoff.lesson7.dto.StudentDto;
import com.grekoff.lesson7.entities.Student;
import com.grekoff.lesson7.services.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/students")
public class StudentController implements StudentControllerAPI{
    private final StudentsService studentsService;
    private final StudentConverter studentConverter;

    public StudentController(StudentsService studentsService, StudentConverter studentConverter) {
        this.studentsService = studentsService;
        this.studentConverter = studentConverter;
    }

    @GetMapping
    public List<StudentDto> showAllStudents(){
        return studentsService.findAllStudents().stream()
                .map(studentConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentConverter.entityToDto(studentsService.findById(id));
    }

    @PostMapping
    public StudentDto addNewStudent(@RequestBody StudentDto studentDto){
        Student student = studentConverter.dtoToEntity(studentDto);
        student.setId(null);
        return studentConverter.entityToDto(studentsService.save(student));
    }

    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto){
        Student student = studentConverter.dtoToEntity(studentDto);
        return studentConverter.entityToDto(studentsService.save(student));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentsService.deleteById(id);
    }
}
