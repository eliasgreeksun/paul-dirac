package com.myprojects.pauldirac.controllers;

import com.myprojects.pauldirac.dao.StudentDAOImpl;
import com.myprojects.pauldirac.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> result = StudentDAOImpl.findAll();
        return result;
    }

}
