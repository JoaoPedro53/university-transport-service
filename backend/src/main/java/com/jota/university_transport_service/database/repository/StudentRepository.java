package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final StudentData studentData;

    public List<Student> listAll(){
        return studentData.getSTUDENTS();
    }

    public List<Student> findByName(String name){
        return studentData.getSTUDENTS().stream().filter(student -> student.getName().equalsIgnoreCase(name)).toList();
    }

    public Optional<Student> findById(Long id){
        return studentData.getSTUDENTS().stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public List<Student> listAllStudentsByBussId(Long id){
        return studentData.getSTUDENTS().stream().filter(student -> student.getBuss().getId().equals(id)).toList();
    }
}
