package edu.example.patient_management.repository;

import edu.example.patient_management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    boolean existsByEmail(String Email);
}
