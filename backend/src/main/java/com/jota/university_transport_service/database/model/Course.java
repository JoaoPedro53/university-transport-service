package com.jota.university_transport_service.database.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Course {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
