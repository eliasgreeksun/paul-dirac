package com.myprojects.pauldirac.controllers;

import com.myprojects.pauldirac.entity.Student;
import com.myprojects.pauldirac.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return student;
//        return studentService.save(student);
    }



}
