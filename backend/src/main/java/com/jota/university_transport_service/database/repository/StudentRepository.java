package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class StudentRepository {
    private final StudentData studentData;

    public List<Student> listAll(){
        return studentData.getSTUDENTS();
    }
}
