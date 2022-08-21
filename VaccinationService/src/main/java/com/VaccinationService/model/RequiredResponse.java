package com.VaccinationService.model;

import com.VaccinationService.entity.Center;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {

    private Center center;
    private List<ResponseCitizen> citizenList;
}
