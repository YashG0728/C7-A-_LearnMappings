package com.example.mappings;

import com.example.mappings.model.Laptop;
import com.example.mappings.model.Student;
import com.example.mappings.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MappingsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MappingsApplication.class, args);

    }

}
