package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.Address;
import com.jota.university_transport_service.database.model.Course;
import com.jota.university_transport_service.database.model.Institution;
import com.jota.university_transport_service.database.model.Student;
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
class StudentRepositoryTest {
    @InjectMocks
    private StudentRepository repository;
    @Mock
    private StudentData studentData;
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
    @DisplayName("listAll return student list when successful")
    void listAll_ReturnListStudents_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);
        Assertions.assertThat(repository.listAll()).isNotNull().hasSameElementsAs(studentList);
    }

    @Test
    @Order(2)
    @DisplayName("findByName return student list with name give when successful")
    void findByName_ReturnListStudentsWithNameGive_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var studentExpected = studentList.getFirst();
        var studentsByName = repository.findByName(studentExpected.getName());
        Assertions.assertThat(studentsByName).isNotNull().contains(studentExpected);
    }

    @Test
    @Order(3)
    @DisplayName("findByName return student empty list when name give is null")
    void findByName_ReturnEmptyListStudent_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var listStudentEmpty = repository.findByName(null);
        Assertions.assertThat(listStudentEmpty).isNotNull().isEmpty();
    }
}