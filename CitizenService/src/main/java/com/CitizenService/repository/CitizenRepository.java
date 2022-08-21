package com.CitizenService.repository;


import com.CitizenService.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    List<Citizen> findByVaccinationCenterId(Long centerId);
}
