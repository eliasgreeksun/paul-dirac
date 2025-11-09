package com.myprojects.pauldirac.dao;

import com.myprojects.pauldirac.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> myQuery = entityManager.createQuery("FROM Student", Student.class);
        List<Student> myEmployees = myQuery.getResultList();
        return myEmployees;
    }

    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
