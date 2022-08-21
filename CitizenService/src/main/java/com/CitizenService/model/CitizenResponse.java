package com.CitizenService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CitizenResponse {

    private Long id;

    private String name;

    private String address;

    private Long vaccinationCenterId;
}
