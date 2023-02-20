package com.example.mappings.service;

import com.example.mappings.model.Address;
import com.example.mappings.model.Laptop;
import com.example.mappings.model.Student;
import com.example.mappings.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(){
        Student student = new Student();
        student.setStudentId(3);
        student.setStudentName("Bharat");
        student.setAbout("I am learning one to many mapping");

//        Laptop laptop = new Laptop();
//        laptop.setLaptopId(103);
//        laptop.setBrand("Dell");
//        laptop.setModelNumber("123457");
//        laptop.setStudent(student);
//        student.setLaptop(laptop);

        Address address = new Address();
        address.setAddress_id(1001);
        address.setCity("Nagpur");
        address.setStreet("Street number 4");
        address.setCountry("India");
        address.setStudent(student);

        Address address1 = new Address();
        address1.setAddress_id(1001);
        address1.setCity("Nagpur");
        address1.setStreet("Street number 4");
        address1.setCountry("India");
        address1.setStudent(student);

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

        student.setAddressList(addressList);

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
