package com.capgemini.genai.clinicaldecision.service;

import com.capgemini.genai.clinicaldecision.model.Patient;
import com.capgemini.genai.clinicaldecision.repository.PatientRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> searchPatients(String name) {
        return patientRepository.findByNameContaining(name);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
