package com.carlos.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface StudentService {
    List<Student> findAllStudents();
    Student findByEmail(String email);
    Student save(Student s);
    void delete(String email);
    Student update(Student s);

}
