package edu.example.patient_management.controller;

import edu.example.patient_management.dto.PatientRequestDTO;
import edu.example.patient_management.model.Patient;
import edu.example.patient_management.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientRequestDTO dto){
        patientService.savePatient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient created successfully");

    }
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
         return ResponseEntity.ok( patientService.getPatients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(
            @PathVariable Integer id,
            @Valid @RequestBody PatientRequestDTO dto) {

        patientService.updatePatients(id, dto);
        return ResponseEntity.ok("Patient updated successfully");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id){
        String s = patientService.deletePatient(id);
        return ResponseEntity.ok(s);
    }



}
