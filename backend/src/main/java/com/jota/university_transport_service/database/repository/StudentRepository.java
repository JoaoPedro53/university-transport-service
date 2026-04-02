package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.Student;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
