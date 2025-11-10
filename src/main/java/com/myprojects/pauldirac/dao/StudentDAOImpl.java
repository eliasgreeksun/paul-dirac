package com.myprojects.pauldirac.dao;

import com.myprojects.pauldirac.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String query = "FROM Student";
        TypedQuery<Student> myQuery = entityManager.createQuery(query, Student.class);
        return myQuery.getResultList();
    }

    @Override
    public Student findById(long id) {
        String query = "FROM Student s where s.id = :id";
        TypedQuery<Student> myQuery = entityManager.createQuery(query, Student.class)
                .setParameter("id", id);
        return myQuery.getSingleResult();
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
