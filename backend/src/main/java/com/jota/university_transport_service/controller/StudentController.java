package com.jota.university_transport_service.controller;

import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("v1/stu")
@AllArgsConstructor
public class StudentController {
    private StudentService service;

    @GetMapping()
    public ResponseEntity<List<Student>> listAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
