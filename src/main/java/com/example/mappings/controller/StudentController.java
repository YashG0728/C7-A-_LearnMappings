package com.example.mappings.controller;

import com.example.mappings.repository.StudentRepository;
import com.example.mappings.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/post")
    public String addStudentdata(){
        studentService.addStudent();
        return "data added Successfully";
    }

    @GetMapping("get/{id}")
    public String findData(@PathVariable int id){
        studentService.findStudent(id);
        return "Data printed in console";
    }
}
