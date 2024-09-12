package com.capgemini.genai.clinicaldecision.repository;

import com.capgemini.genai.clinicaldecision.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByNameContaining(String name);
}
