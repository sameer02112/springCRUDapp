package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //get functionality
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    
    //add functinallity
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail((student.getEmail()));
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }
    //delete functionality
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(("student with id "+ studentId+" doest not exists" ));
        }
        studentRepository.deleteById(studentId);
    }
    //update functionality
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        //
    }
}
