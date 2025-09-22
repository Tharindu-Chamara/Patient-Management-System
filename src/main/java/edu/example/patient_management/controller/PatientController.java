package edu.example.patient_management.controller;

import edu.example.patient_management.dto.PatientRequestDTO;
import edu.example.patient_management.model.Patient;
import edu.example.patient_management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public void addPatient(@RequestBody PatientRequestDTO dto){
        patientService.savePatient(dto);

    }

    @GetMapping
    public List<Patient> getAllPatients(){
         return patientService.getPatients();
    }


}
