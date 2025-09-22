package edu.example.patient_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {

    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate registerData;




}
