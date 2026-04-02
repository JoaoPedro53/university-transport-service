package com.jota.university_transport_service.service;

import com.jota.university_transport_service.database.model.Address;
import com.jota.university_transport_service.database.model.Course;
import com.jota.university_transport_service.database.model.Institution;
import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.database.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService service;
    @Mock
    private StudentRepository repository;
    private final List<Student> studentList = new ArrayList<>();

    @BeforeEach
    void init(){
        var adress = Address.builder().addressHouse("Frei Fernando").cep("5777-0000").houseNumber("22").city("Cajueiro")
                .state("Alagoas").build();
        var course = Course.builder().name("Bacharel em SI").startDate(LocalDate.of(2025, 9, 10))
                .endDate(LocalDate.of(2029, 9, 10)).build();
        var institution = Institution.builder().name("IFAL").build();

        var student1 = Student.builder().id(1L).name("João Pedro").age(19).phoneNumber("82 996704350").cpf("121253013-90").registration("82726X-AL1")
                .address(adress).course(course).institution(institution).build();
        var student2 = Student.builder().id(1L).name("Alfredo").age(19).phoneNumber("82 996704350").cpf("121873013-90").registration("82726X-AL1")
                .address(adress).course(course).institution(institution).build();
        studentList.addAll(List.of(student1, student2));
    }

    @Test
    @Order(1)
    @DisplayName("findAll return list with all students when successful")
    void findAll_ReturnListWithAllStudents_WhenSuccessful(){
        BDDMockito.when(repository.listAll()).thenReturn(studentList);

        var emptyStudentsList = service.findAll(null);
        Assertions.assertThat(emptyStudentsList).hasSameElementsAs(studentList);
    }

    @Test
    @Order(2)
    @DisplayName("findAll return list students by give name")
    void findAll_ReturnListWithStudentsByGiveName_WhenSuccessful(){
        var studentExpected = studentList.getFirst();
        BDDMockito.when(repository.findByName(studentExpected.getName())).thenReturn(List.of(studentExpected));

        var emptyStudentsList = service.findAll(studentExpected.getName());
        Assertions.assertThat(emptyStudentsList).contains(studentExpected);
    }

    @Test
    @Order(3)
    @DisplayName("findAll return empty list students when name give not found")
    void findAll_ReturnEmptyListWhenNameGiveNotFound_WhenSuccessful(){
        BDDMockito.when(repository.findByName("x")).thenReturn(List.of());

        var emptyStudentsList = service.findAll("x");
        Assertions.assertThat(emptyStudentsList).isEmpty();
    }


}