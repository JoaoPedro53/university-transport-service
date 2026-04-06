package com.jota.university_transport_service.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Buss {
    private Long id;
    private Driver driver;
    private String color;
    private String plate;
    private String bussSeats;
    private RouterBuss routerBuss;
}
