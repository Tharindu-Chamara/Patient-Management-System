package edu.example.patient_management.service;

import edu.example.patient_management.dto.PatientRequestDTO;
import edu.example.patient_management.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients();

    void savePatient(PatientRequestDTO dto);
}
