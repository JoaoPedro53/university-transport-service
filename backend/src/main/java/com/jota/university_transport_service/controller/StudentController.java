package com.jota.university_transport_service.controller;

import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.mapper.StudentMapper;
import com.jota.university_transport_service.response.StudentGetResponse;
import com.jota.university_transport_service.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/stu")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping()
    public ResponseEntity<List<StudentGetResponse>> listAll(@RequestParam(required = false) String name){
        var students = service.findAll(name);
        var studentListGetResponse = mapper.toStudentListGetResponse(students);
        return ResponseEntity.ok(studentListGetResponse);
    }
}
