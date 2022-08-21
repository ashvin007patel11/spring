package com.VaccinationService.service;

import com.VaccinationService.entity.Center;
import com.VaccinationService.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    public Center addCenter(Center center) {
        return centerRepository.save(center);
    }

    public Center updateCenter(Long id, Center center) {

        Center center1 = centerRepository.findById(id).get();
        center1.setCenterName(center.getCenterName());
        center1.setCenterAddress(center.getCenterAddress());
        return centerRepository.save(center1);
    }

    public Center updateCenter1(Center center) {
        Center center1 = centerRepository.findById(center.getCid()).get();
        center1.setCenterName(center.getCenterName());
        center1.setCenterAddress(center.getCenterAddress());
        return centerRepository.save(center1);
    }

    public Center getCenterById(Long id) {
        Center center = centerRepository.findById(id).get();
        return center;
    }

    public void deleteCenter(Long id) {
        centerRepository.deleteById(id);
    }

    public List<Center> getAllCenter() {
        List<Center> centerList = centerRepository.findAll();
        return centerList;
    }

}
