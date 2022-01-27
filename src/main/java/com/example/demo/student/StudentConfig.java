package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student sameer = new Student(
                        "Sameer",
                        "sameer@gmail.com",
                        LocalDate.of(1998, Month.JUNE,2)
                        );

            Student Alex =  new Student(
                        "Alex",
                        "alex@gmail.com",
                        LocalDate.of(1995, Month.JUNE,2)
                        );
            studentRepository.saveAll(List.of(sameer,Alex));
        };
    }
}
