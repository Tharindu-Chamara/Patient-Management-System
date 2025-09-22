package edu.example.patient_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.patient_management.dto.PatientRequestDTO;
import edu.example.patient_management.model.Patient;
import edu.example.patient_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

   private final PatientRepository patientRepository;
   private  final ObjectMapper mapper;


    @Override
    public List<Patient> getPatients() {
      return patientRepository.findAll();

    }

    @Override
    public void savePatient(PatientRequestDTO dto) {
        patientRepository.save(mapper.convertValue(dto, Patient.class));
    }
}

