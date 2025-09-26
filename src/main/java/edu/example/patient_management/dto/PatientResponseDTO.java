package edu.example.patient_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientResponseDTO {

    private Integer id;
    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;



}
