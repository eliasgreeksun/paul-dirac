package com.myprojects.pauldirac.dao;

import com.myprojects.pauldirac.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAll();
    Student findById(long id);
    Student save(Student student);
    void deleteById(long id);

}
