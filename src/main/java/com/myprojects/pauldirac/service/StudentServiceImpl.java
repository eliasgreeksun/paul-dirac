package com.myprojects.pauldirac.service;

import com.myprojects.pauldirac.dao.StudentDAO;
import com.myprojects.pauldirac.dao.StudentDAOImpl;
import com.myprojects.pauldirac.entity.Employee;
import com.myprojects.pauldirac.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(long id) {
        return studentDAO.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }
}
