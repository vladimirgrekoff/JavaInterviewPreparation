package com.grekoff.hibernate.repository;

import com.grekoff.hibernate.entity.Student;
import com.grekoff.hibernate.service.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;

import java.util.List;
import java.util.Queue;


public class StudentDaoImpl implements StudentDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public StudentDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Student findById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student student = session
                    .createQuery("select student from Student student where student.name = :name", Student.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s", Student.class).getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createMutationQuery("delete from Student s where s.id= :id")
                   .setParameter("id", id)
                   .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Student saveOrUpdate(Student student) {
        try (Session session = sessionFactoryUtils.getSession()) {
            Long id = student.getId();
            String name = student.getName();
            int mark = student.getMark();
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student save(Student student) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createMutationQuery("INSERT INTO Student(name, mark) VALUES(?1, ?2)")
                    .setParameter(1, student.getName())
                    .setParameter(2, student.getMark())
                    .executeUpdate();
            session.getTransaction().commit();
            return student;
        }
    }
    @Override
    public Student update(Student student) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createMutationQuery("UPDATE Student SET name = :strName, mark = :intMark WHERE id =: lngId")
                    .setParameter("lngId", student.getId())
                    .setParameter("strName", student.getName())
                    .setParameter("intMark", student.getMark())
                    .executeUpdate();
            session.getTransaction().commit();
            return student;
        }
    }


}
