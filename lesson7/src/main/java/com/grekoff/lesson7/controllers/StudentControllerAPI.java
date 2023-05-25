package com.grekoff.lesson7.controllers;

import com.grekoff.lesson7.dto.StudentDto;

import java.util.List;

public interface StudentControllerAPI {

    List<StudentDto> showAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto addNewStudent(StudentDto studentDto);

    StudentDto updateStudent(StudentDto studentDto);

    void deleteById(Long id);
}
