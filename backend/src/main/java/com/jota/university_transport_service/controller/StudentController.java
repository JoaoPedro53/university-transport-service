package com.jota.university_transport_service.controller;

import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.mapper.StudentMapper;
import com.jota.university_transport_service.response.StudentGetResponse;
import com.jota.university_transport_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/stu")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentGetResponse>> listAll(@RequestParam(required = false) String name){

        var students = service.findAll(name);
        var studentListGetResponse = mapper.toStudentListGetResponse(students);

        return ResponseEntity.ok(studentListGetResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentGetResponse> findById(@PathVariable Long id){
        var student = service.findByIdOrElseThrow(id);
        var studentGetResponse = mapper.toStudentGetResponse(student);

        return ResponseEntity.ok(studentGetResponse);
    }

    @GetMapping("/studentsBuss/{id}")
    public ResponseEntity<List<StudentGetResponse>> listAllStudentsByBussId(@PathVariable Long id){
        var student = service.listAllStudentsByBussId(id);
        var studentListGetResponse = mapper.toStudentListGetResponse(student);

        return ResponseEntity.ok(studentListGetResponse);
    }
}
