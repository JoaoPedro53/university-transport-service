package com.jota.university_transport_service.service;

import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.database.repository.StudentData;
import com.jota.university_transport_service.database.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> findAll(){
        return repository.listAll();
    }
}
