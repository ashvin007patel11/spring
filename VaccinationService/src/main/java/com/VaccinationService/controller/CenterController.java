package com.VaccinationService.controller;

import com.VaccinationService.entity.Center;
import com.VaccinationService.entity.MyUser;
import com.VaccinationService.model.RequiredResponse;
import com.VaccinationService.model.ResponseCitizen;
import com.VaccinationService.service.CenterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/vs")
@RestController
public class CenterController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CenterService centerService;

    @PostMapping("/center")
    public Center addCenter(@RequestBody Center center) {
        return centerService.addCenter(center);
    }

    @GetMapping("/onlyCenter/{id}")
    public Center getCenterById(@PathVariable Long id) {
        return centerService.getCenterById(id);
    }

    @GetMapping("/centers")
    public List<Center> getAllCenter() {
        return centerService.getAllCenter();
    }

    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    @GetMapping("/center/{centerId}")
    public ResponseEntity<RequiredResponse> getAllDataByCenterId(@PathVariable Long centerId) {
        RequiredResponse requiredResponse = new RequiredResponse();
        Center center = centerService.getCenterById(centerId);
        requiredResponse.setCenter(center);
        List<ResponseCitizen> citizenList = restTemplate.getForObject("http://localhost:8081/cs/citizens/" + centerId, List.class);
        requiredResponse.setCitizenList(citizenList); //localhost:8081/citizens/1
        return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
    }

    public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Long centerId) {
        RequiredResponse requiredResponse = new RequiredResponse();
        Center center = centerService.getCenterById(centerId);
        requiredResponse.setCenter(center);
        List<ResponseCitizen> citizenList = restTemplate.getForObject("http://localhost:8081/cs/citizens/" + centerId, List.class);
        requiredResponse.setCitizenList(citizenList); //localhost:8081/citizens/1
        //   return requiredResponse;
        return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
    }

    @PutMapping("/center/{id}")
    public Center updateCenter(@PathVariable Long id, @RequestBody Center Center) {
        return centerService.updateCenter(id, Center);
    }

    @PutMapping("/center")
    public Center updateCenter1(@RequestBody Center Center) {
        return centerService.updateCenter1(Center);
    }

    @DeleteMapping("center/{id}")
    public String deleteCenter(@PathVariable Long id) {
        centerService.deleteCenter(id);
        return "record deleted";
    }

    @GetMapping("/test")
    public ResponseEntity<MyUser> getData() {
        MyUser myUser = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", MyUser.class);
        return new ResponseEntity<MyUser>(myUser, HttpStatus.OK);
    }
}
