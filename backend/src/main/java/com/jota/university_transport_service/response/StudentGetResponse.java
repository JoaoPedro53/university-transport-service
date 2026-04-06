package com.jota.university_transport_service.response;

import com.jota.university_transport_service.database.model.Address;
import com.jota.university_transport_service.database.model.Buss;
import com.jota.university_transport_service.database.model.Course;
import com.jota.university_transport_service.database.model.Institution;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentGetResponse {
    private Long id;
    private String name;
    private Integer age;
    private String cpf;
    private String registration;
    private Institution institution;
    private String phoneNumber;
    private Address address;
    private Course course;
    private Buss buss;
}
