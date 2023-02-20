package com.example.mappings.service;

import com.example.mappings.model.Laptop;
import com.example.mappings.model.Student;
import com.example.mappings.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(){
        Student student = new Student();
        student.setStudentId(2);
        student.setStudentName("Yash");
        student.setAbout("I am software developer");

        Laptop laptop = new Laptop();
        laptop.setLaptopId(102);
        laptop.setBrand("Dell");
        laptop.setModelNumber("123457");

        laptop.setStudent(student);

        student.setLaptop(laptop);

        Student save = studentRepository.save(student);
        log.info("Save Student : {}"+ " " + save);
    }

    public void findStudent(int id){
        Student student = studentRepository.findById(id).get();
        log.info("name is {} " + student.getStudentName());
        Laptop laptop = student.getLaptop();
        log.info("Laptop "+ " Brand : "+ laptop.getBrand()+ " Model : " +laptop.getModelNumber());
    }
}
