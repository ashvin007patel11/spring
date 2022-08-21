package com.CitizenService.service;

import com.CitizenService.entity.Citizen;
import com.CitizenService.model.CitizenResponse;
import com.CitizenService.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitizenService {


    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen addCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public Citizen updateCitizen(Long id, Citizen citizen) {
        Citizen citizen1 = citizenRepository.findById(id).get();
        citizen1.setName(citizen.getName());
        citizen1.setAddress(citizen.getAddress());
        citizen1.setPassword(citizen.getPassword());
        return citizenRepository.save(citizen1);
    }

    public Citizen updateCitizen1(Citizen citizen) {
        Citizen citizen1 = citizenRepository.findById(citizen.getId()).get();
        citizen1.setName(citizen.getName());
        citizen1.setAddress(citizen.getAddress());
        citizen1.setPassword(citizen.getPassword());
        return citizenRepository.save(citizen1);
    }

    public Citizen getCitizenById(Long id) {
        Citizen citizen = citizenRepository.findById(id).get();
        return citizen;
    }

    public void deleteCitizen(Long id) {
        citizenRepository.deleteById(id);
    }

    public List<Citizen> getAllCitizen() {
        List<Citizen> citizenList = citizenRepository.findAll();
        return citizenList;
    }

    public List<CitizenResponse> getAllCitizen(Long centerId) {
        List<Citizen> citizenList = citizenRepository.findByVaccinationCenterId(centerId);
        //  return citizenList.stream().map(s->new CitizenResponse(s.getId(),s.getName(),s.getPassword(),s.getVaccinationCenterId())).collect(Collectors.toList());
        return citizenList.stream().map(c -> citizenToDto(c)).collect(Collectors.toList());
    }

    public CitizenResponse citizenToDto(Citizen citizen) {
        CitizenResponse citizenResponse = new CitizenResponse(citizen.getId(), citizen.getName(), citizen.getAddress(), citizen.getVaccinationCenterId());
        return citizenResponse;
    }
}
