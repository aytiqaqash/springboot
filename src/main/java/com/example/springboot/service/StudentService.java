package com.example.springboot.service;


import com.example.springboot.entity.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student student) {
       Optional<Student> foundedStudent = studentRepository.findById(id);
       if(foundedStudent.isPresent()){
           Student existingStudent  = foundedStudent.get();
           existingStudent.setFirstName(student.getFirstName());
           existingStudent.setLastName(student.getLastName());
           existingStudent.setDateOfBirth(student.getDateOfBirth());
           existingStudent.setNumber(student.getNumber());

           return studentRepository.save(existingStudent);
       }

       return null;
    }
}
