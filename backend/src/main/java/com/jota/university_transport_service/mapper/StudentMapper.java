package com.jota.university_transport_service.mapper;

import com.jota.university_transport_service.database.model.Student;
import com.jota.university_transport_service.response.StudentGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

//    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(100_000))")
    StudentGetResponse toStudentGetResponse(Student student);
    List<StudentGetResponse> toStudentListGetResponse(List<Student> student);
}
