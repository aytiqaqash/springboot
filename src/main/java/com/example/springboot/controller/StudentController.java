package com.example.springboot.controller;

import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/create/student")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/delete/student/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/student/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

}
