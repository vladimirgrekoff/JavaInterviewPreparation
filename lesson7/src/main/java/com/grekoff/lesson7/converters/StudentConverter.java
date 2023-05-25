package com.grekoff.lesson7.converters;

import com.grekoff.lesson7.dto.StudentDto;
import com.grekoff.lesson7.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter{
    public Student dtoToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

    public StudentDto entityToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return studentDto;
    }
}
