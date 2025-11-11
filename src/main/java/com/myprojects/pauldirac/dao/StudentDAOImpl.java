package com.myprojects.pauldirac.dao;

import com.myprojects.pauldirac.entity.Student;
import com.myprojects.pauldirac.exceptions.CouldNotDeleteStudentException;
import com.myprojects.pauldirac.exceptions.StudentNotFoundException;
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
        return entityManager.createQuery(query, Student.class)
            .setParameter("id", id)
            .getResultStream()
            .findFirst()
            .orElseThrow(() -> new StudentNotFoundException("Student id=" + id + " not found"));
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void deleteById(long id) {
        Student myStudent = entityManager.find(Student.class, id);
        if (myStudent == null) {
            throw new CouldNotDeleteStudentException("Could not delete student with id=" + id);
        }
        entityManager.remove(myStudent);
    }
}
