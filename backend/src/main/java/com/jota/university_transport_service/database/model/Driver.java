package com.jota.university_transport_service.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Driver {
    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private String phoneNumber;
    private Address address;
}
