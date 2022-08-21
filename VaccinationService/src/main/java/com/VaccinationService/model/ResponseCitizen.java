package com.VaccinationService.model;

/*
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
*/

/*
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String password;

    private Long vaccinationCenterId;

}
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCitizen {
    private Long id;
    private String name;
    private String address;
    private Long vaccinationCenterId;

}