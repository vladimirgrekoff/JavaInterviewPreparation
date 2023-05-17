package com.grekoff.hibernate.entity;

import jakarta.persistence.*;




@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student(Long id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public void print(){
        System.out.println("Id студента = " + id + "; Имя = " + name + "; Оценка = " + mark);
    }

    @Override
    public String toString() {
        return "Student{" + "id = " + id + "; Имя = '" + name + "'"  + "; Оценка = " + mark + "}";
    }
}