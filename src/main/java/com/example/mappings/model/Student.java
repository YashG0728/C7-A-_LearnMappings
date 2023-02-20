package com.example.mappings.model;

import jakarta.persistence.*;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_student") //parentTable
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String about;

    //one laptop
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    //mapped by use for bi-directional mapping (both table contain foreign keys) //unidirectional
    //cascadeType is use to save data of parent table and child table both(all operations perform for both tables e.g - remove & save)
    //here we r using cascade so we dont need to save laptop is save with student data(is we r not using cascade we need to save laptop data manually)
    private Laptop laptop;

    //many address
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    //mapped by means to convert uni-directional mapping into bi-directionalmapping
    //cascade used tp perform operations in both table at same time (parent and child)
    private List<Address> addressList = new ArrayList<>();

    public Student() {

    }

    public Student(int studentId, String studentName, String about, Laptop laptop) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.about = about;
        this.laptop = laptop;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
