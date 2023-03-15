package com.carlos.student;


import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    //al crear en el constructor no es necesaria la etiqueta autowired para utilizar el servicio
    // si lo fuera a utilizar por fuera del controlador necesitare la etiquera @autowired y si
    // no lo utilizara seria necesario instanciar el objeto.
    StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @GetMapping
    public List<Student> findAllStudents(){
        return service.findAllStudents();
    }
    @PostMapping
    public Student save(@RequestBody Student student){
        return service.save(student);
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student s){
        return service.update(s);
    }
    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        service.delete(email);
    }
}
