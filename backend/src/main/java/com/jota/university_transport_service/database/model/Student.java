package com.jota.university_transport_service.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String cpf;
    private String registration;
    private Institution institution;
    private String phoneNumber;
    private Address address;
    private Course course;
}
