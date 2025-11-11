package com.myprojects.pauldirac.controllers;

import com.myprojects.pauldirac.dto.StudentPatchDTO;
import com.myprojects.pauldirac.entity.Student;
import com.myprojects.pauldirac.mappers.StudentMapper;
import com.myprojects.pauldirac.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentRestController(
            StudentService studentService,
            StudentMapper studentMapper
    ) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
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
        if (student.getId() != 0L) {
            student.setId(0);
        }
        return studentService.save(student);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok("Student (id=" + id + ") deleted successfully.");
    }

    @PutMapping("students/{id}")
    public Student update(@PathVariable long id, @RequestBody StudentPatchDTO updates) {
        Student studentToUpdate = studentService.findById(id);
        studentMapper.updateStudentFromDto(updates, studentToUpdate);
        return studentToUpdate;
    }
}
