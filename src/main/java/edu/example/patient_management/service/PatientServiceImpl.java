package edu.example.patient_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.patient_management.dto.PatientRequestDTO;
import edu.example.patient_management.exception.EmailAlreadyExistsException;
import edu.example.patient_management.exception.PatientNotFoundException;
import edu.example.patient_management.model.Patient;
import edu.example.patient_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        if(patientRepository.existsByEmail(dto.getEmail())){
            throw new EmailAlreadyExistsException("Email "+ dto.getEmail()+" already exists");
        }
        patientRepository.save(mapper.convertValue(dto, Patient.class));
    }

    @Override
    public void updatePatients(Integer id, PatientRequestDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + id + " not found"));

        if (!patient.getEmail().equals(dto.getEmail()) &&
                patientRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Email " + dto.getEmail() + " already exists");
        }

        patient.setAddress(dto.getAddress());
        patient.setEmail(dto.getEmail());
        patient.setName(dto.getName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setRegisterDate(dto.getRegisterDate());


        patientRepository.save(patient);
    }

    @Override
    public String deletePatient(Integer id) {
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }
}

