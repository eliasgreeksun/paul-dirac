package com.myprojects.pauldirac.service;

import com.myprojects.pauldirac.entity.Employee;
import com.myprojects.pauldirac.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();
    Student findById(long id);
    Student save(Student employee);
    boolean deleteById(long id);
}
