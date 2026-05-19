package com.example.WebApp.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "patients", contextId = "patientClient") //Dynamic route with Consul
public interface PatientClient {

        @GetMapping("/patients")
        List<Object> getAllPatients(); //Dto will be added later on

}
