package com.CitizenService.controller;

import com.CitizenService.entity.Citizen;
import com.CitizenService.model.CitizenResponse;
import com.CitizenService.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cs")
@RestController
public class CitizenController {


    @Autowired
    private CitizenService citizenService;

    @PostMapping("/citizen")
    public Citizen addCitizen(@RequestBody Citizen citizen) {
        return citizenService.addCitizen(citizen);
    }

    @GetMapping("/citizen/{id}")
    public Citizen getEmpById(@PathVariable Long id) {
        return citizenService.getCitizenById(id);
    }

    @GetMapping("/citizens")
    public List<Citizen> getAllCitizen() {
        return citizenService.getAllCitizen();
    }

    @GetMapping("/citizens/{centerId}")
    public List<CitizenResponse> getAllCitizen(@PathVariable Long centerId) {
        return citizenService.getAllCitizen(centerId);
    }

    @PutMapping("/citizen/{id}")
    public Citizen updateCitizen(@PathVariable Long id, @RequestBody Citizen citizen) {
        return citizenService.updateCitizen(id, citizen);
    }

    @PutMapping("/citizen")
    public Citizen updateCitizen1(@RequestBody Citizen citizen) {
        return citizenService.updateCitizen1(citizen);
    }

    @DeleteMapping("citizen/{id}")
    public String deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
        return "record deleted";
    }
}
