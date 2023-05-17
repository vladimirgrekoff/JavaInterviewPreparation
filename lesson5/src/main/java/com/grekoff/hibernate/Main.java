package com.grekoff.hibernate;


import com.grekoff.hibernate.entity.Student;
import com.grekoff.hibernate.repository.StudentDao;
import com.grekoff.hibernate.repository.StudentDaoImpl;
import com.grekoff.hibernate.service.SessionFactoryUtils;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        SessionFactoryUtils.init();


        System.out.println("заполнить таблицу");
        //fillTable
//        fillTable();

        fillTableAnother(sessionFactoryUtils);

        System.out.println();

        try {
            StudentDao studentDao = new StudentDaoImpl(sessionFactoryUtils);
            Student student;

            System.out.println("данные студента по Id");
            student = studentDao.findById(989L);
            student.print();

            System.out.println("данные студента по имени");
            student = studentDao.findByName("Джон100");
            student.print();

            System.out.println("изменить данные студента");
            student = new Student(1L,"Василий", 5);
            System.out.println(studentDao.update(student));

            System.out.println("добавить студента по имени без оценки");
            student = new Student("Иван");
            System.out.println(studentDao.saveOrUpdate(student));

            System.out.println("добавить студента по имени с оценкой");
            student = new Student("Федор", 5);

            System.out.println(studentDao.save(student));
            System.out.println("найти по имени");
            System.out.println(studentDao.findByName("Федор"));

            System.out.println("удалить студента по Id = 5");
            studentDao.deleteById(5L);
            System.out.println("найти по Id = 5: " + studentDao.findById(5L));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionFactoryUtils.shutdown();
        }
    }

    public static void fillTable() {
        Student student = new Student();
        String studentName;
        int i = 1;
        while (i < 1001) {
            studentName = "Джон" + i;
            student.setName(studentName);
            student.setMark(5);
            Session session = SessionFactoryUtils.getSession();
            session.getTransaction().begin();
            session.merge(student);
            session.getTransaction().commit();
            i++;
        }
    }

    public static void fillTableAnother(SessionFactoryUtils sessionFactoryUtils) {
        StudentDao studentDao = new StudentDaoImpl(sessionFactoryUtils);
        Student student = new Student();
        String studentName;
        int i = 1;
        while (i < 1001) {
            studentName = "Джон" + i;
            student.setName(studentName);
            student.setMark(5);
            studentDao.save(student);
            i++;
        }
    }
}
