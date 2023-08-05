package com.example.springboot.controller;

import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

}
