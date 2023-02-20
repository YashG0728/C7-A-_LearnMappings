package com.example.mappings.service;

import com.example.mappings.model.*;
import com.example.mappings.repository.CategoryRepo;
import com.example.mappings.repository.ProductRepo;
import com.example.mappings.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    public void addStudent(){
//        Student student = new Student();
//        student.setStudentId(3);
//        student.setStudentName("Bharat");
//        student.setAbout("I am learning one to many mapping");

//        Laptop laptop = new Laptop();
//        laptop.setLaptopId(103);
//        laptop.setBrand("Dell");
//        laptop.setModelNumber("123457");
//        laptop.setStudent(student);
//        student.setLaptop(laptop);

//        Address address = new Address();
//        address.setAddress_id(1001);
//        address.setCity("Nagpur");
//        address.setStreet("Street number 4");
//        address.setCountry("India");
//        address.setStudent(student);
//
//        Address address1 = new Address();
//        address1.setAddress_id(1001);
//        address1.setCity("Nagpur");
//        address1.setStreet("Street number 4");
//        address1.setCountry("India");
//        address1.setStudent(student);
//
//        List<Address> addressList = new ArrayList<>();
//        addressList.add(address);
//        addressList.add(address1);
//
//        student.setAddressList(addressList);
//
//        Student save = studentRepository.save(student);
//        log.info("Save Student : {}"+ " " + save);

        //many to many
        Product product = new Product();
        product.setProduct_id(45);
        product.setProduct_name("Iphone 14 pro max");

        Product product2 = new Product();
        product2.setProduct_id(46);
        product2.setProduct_name("Samsung pro max");

        Product product3 = new Product();
        product3.setProduct_id(47);
        product3.setProduct_name("SamsungTV");


        Category category = new Category();
        category.setCategory_id(55);
        category.setTitle("Electronics");

        Category category1 = new Category();
        category1.setCategory_id(56);
        category1.setTitle("Mobile phones");

        List<Product> categorylist1 = category.getProductList();
        categorylist1.add(product);
        categorylist1.add(product2);
        categorylist1.add(product3);

        List<Product> categorylist2 = category1.getProductList();
        categorylist2.add(product);
        categorylist2.add(product2);

        categoryRepo.save(category);
        categoryRepo.save(category1);

    }

    public void findStudent(int id){
//        Student student = studentRepository.findById(id).get();
//        log.info("name is {} " + student.getStudentName());
//        Laptop laptop = student.getLaptop();
//        log.info("Laptop "+ " Brand : "+ laptop.getBrand()+ " Model : " +laptop.getModelNumber());

        Category category = categoryRepo.findById(id).get();
        System.out.println(category.getProductList().size());

        Product product = productRepo.findById(id).get();
        System.out.println(product.getCategoryList().size());
    }
}
