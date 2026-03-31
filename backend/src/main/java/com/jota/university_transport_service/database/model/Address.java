package com.jota.university_transport_service.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {
    private String addressHouse;
    private String city;
    private String state;
    private String houseNumber;
    private String cep;
}
