package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class StudentData {
    private final List<Student> STUDENTS = new ArrayList<>();

    {
        var routerBuss = RouterBuss.builder().name("Fernandes Lima").build();
        var adress = Address.builder().addressHouse("Frei Fernando").cep("5777-0000").houseNumber("22").city("Cajueiro")
                .state("Alagoas").build();
        var driver = Driver.builder().id(ThreadLocalRandom.current().nextLong(100_000)).name("João Pedro").age(19).phoneNumber("82 998704350").cpf("121253013-90")
                .address(adress).build();
        var course = Course.builder().name("Bacharel em SI").startDate(LocalDate.of(2025, 9, 10))
                .endDate(LocalDate.of(2029, 9, 10)).build();
        var institution = Institution.builder().name("IFAL").build();
        var buss = Buss.builder().id(ThreadLocalRandom.current().nextLong(100_000)).bussSeats("42").color("Azul").plate("A654-87A").routerBuss(routerBuss).driver(driver).build();

        var student1 = Student.builder().id(1L).name("João Pedro").age(19).phoneNumber("82 996704350").cpf("121253013-90").registration("82726X-AL1")
                .address(adress).course(course).institution(institution).buss(buss).build();
        var student2 = Student.builder().id(2L).name("Alfredo").age(19).phoneNumber("82 996704350").cpf("121873013-90").registration("82726X-AL1")
                .address(adress).course(course).institution(institution).buss(buss).build();
        STUDENTS.addAll(List.of(student1, student2));
    }

    public List<Student> getSTUDENTS() {
        return STUDENTS;
    }
}
