package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false, columnDefinition = "LONG TEXT")
    private String lastName;

    @Column(name="date_of_birth", nullable = false)
    private Integer dateOfBirth;

    @Column(nullable = false, unique = true)
    private Integer number;


}
