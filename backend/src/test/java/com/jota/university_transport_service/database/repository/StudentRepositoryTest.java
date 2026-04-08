package com.jota.university_transport_service.database.repository;

import com.jota.university_transport_service.database.model.*;
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
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

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
        studentList.addAll(List.of(student1, student2));
    }

    @Test
    @Order(1)
    @DisplayName("listAll return student list when successful")
    void listAll_ReturnListStudents_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);
        Assertions.assertThat(repository.listAll()).hasSameElementsAs(studentList);
    }

    @Test
    @Order(2)
    @DisplayName("findByName return student list with name give when successful")
    void findByName_ReturnListStudentsWithNameGive_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var studentExpected = studentList.getFirst();
        var studentsByName = repository.findByName(studentExpected.getName());
        Assertions.assertThat(studentsByName).contains(studentExpected);
    }

    @Test
    @Order(3)
    @DisplayName("findByName return student empty list when name give is null")
    void findByName_ReturnEmptyListStudent_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var listStudentEmpty = repository.findByName(null);
        Assertions.assertThat(listStudentEmpty).isEmpty();
    }

    @Test
    @Order(4)
    @DisplayName("findById return student by id")
    void findById_ReturnStudentById_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var studentExpected = studentList.getFirst();
        var studentById = repository.findById(studentExpected.getId());

        Assertions.assertThat(studentById).contains(studentExpected);
    }

    @Test
    @Order(4)
    @DisplayName("findById return empty when student by id is not found")
    void findById_ReturnEmptyStudentById_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var studentById = repository.findById(100L);
        Assertions.assertThat(studentById).isEmpty();
    }

    @Test
    @Order(5)
    @DisplayName("listAllStudentsByBussId return students list with same buss give when buss is found")
    void listAllStudentsByBussId_ReturnStudentsListWithSameBuss_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var idBuss = studentList.getFirst().getBuss().getId();
        var studentsByBuss = repository.listAllStudentsByBussId(idBuss);
        Assertions.assertThat(studentsByBuss).hasSameElementsAs(studentList);
    }

    @Test
    @Order(5)
    @DisplayName("listAllStudentsByBussId return students empty list when give buss not found")
    void listAllStudentsByBussId_ReturnStudentsEmptyListWhenBussIsNotFound_WhenSuccessful(){
        BDDMockito.when(studentData.getSTUDENTS()).thenReturn(studentList);

        var studentsByBuss = repository.listAllStudentsByBussId(100L);
        Assertions.assertThat(studentsByBuss).isEmpty();
    }
}