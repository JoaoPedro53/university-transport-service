package com.jota.university_transport_service.service;

import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.database.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> findAll(String name){
        return name == null ? repository.listAll() : repository.findByName(name);
    }

    public Student findByIdOrElseThrow(Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found."));
    }

    public List<Student> listAllStudentsByBussId(Long id){
        return repository.listAllStudentsByBussId(id);
    }
}
