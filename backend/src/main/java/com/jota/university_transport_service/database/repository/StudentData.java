package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.Address;
import com.jota.university_transport_service.database.model.Course;
import com.jota.university_transport_service.database.model.Institution;
import com.jota.university_transport_service.database.model.Student;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentData {
    private final List<Student> STUDENTS = new ArrayList<>();

    {
        var adress = Address.builder().addressHouse("Frei Fernando").cep("5777-0000").houseNumber("22").city("Cajueiro")
                .state("Alagoas").build();
        var course = Course.builder().name("Bacharel em SI").startDate(LocalDate.of(2025, 9, 10))
                .endDate(LocalDate.of(2029, 9, 10)).build();
        var institution = Institution.builder().name("IFAL").build();

        var student1 = Student.builder().id(1L).name("João Pedro").age(19).phoneNumber("82 996704350").cpf("121253013-90").registration("82726X-AL1")
                .address(adress).course(course).institution(institution).build();
        var student2 = Student.builder().id(1L).name("Alfredo").age(19).phoneNumber("82 996704350").cpf("121873013-90").registration("82726X-AL1")
                .address(adress).course(course).institution(institution).build();
        STUDENTS.addAll(List.of(student1, student2));
    }

    public List<Student> getSTUDENTS() {
        return STUDENTS;
    }
}
