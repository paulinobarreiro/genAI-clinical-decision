package com.capgemini.genai.clinicaldecision.service;

import com.capgemini.genai.clinicaldecision.model.Patient;
import com.capgemini.genai.clinicaldecision.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    void testSavePatient() {
        // Criar um novo paciente
        Patient patient = new Patient();
        patient.setName("Wilson Bola");
        patient.setDocument("958658");
        patient.setNum_utente("UTe4545");

        // Salvar o paciente
        Patient savedPatient = patientService.registerPatient(patient);

        // Verificar se o ID foi gerado e se os dados foram persistidos corretamente
        assertNotNull(savedPatient.getId());
        assertEquals("Wilson Bola", savedPatient.getName());
        assertEquals("958658", savedPatient.getDocument());
        assertEquals("UTe4545", savedPatient.getNum_utente());
    }
}
