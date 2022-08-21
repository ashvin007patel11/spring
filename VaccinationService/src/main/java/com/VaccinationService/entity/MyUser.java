package com.VaccinationService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyUser {

    private int id;
    private int userId;
    private String title;
    @JsonProperty("completed")
    private String status;
}
