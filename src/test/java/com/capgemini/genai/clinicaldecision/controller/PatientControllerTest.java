package com.capgemini.genai.clinicaldecision.controller;

import com.capgemini.genai.clinicaldecision.model.Patient;
import com.capgemini.genai.clinicaldecision.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @Mock
    private Model model;

    @InjectMocks
    private PatientController patientController;

    public PatientControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListPatients() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());
        when(patientService.getAllPatients()).thenReturn(patients);

        String viewName = patientController.listPatients(model);

        verify(patientService, times(1)).getAllPatients();
        verify(model, times(1)).addAttribute("patients", patients);
        assertEquals("patients", viewName);
    }

    @Test
    void testRegisterPatient() {
        Patient patient = new Patient();
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);

        when(patientService.getAllPatients()).thenReturn(patients);

        String viewName = patientController.registerPatient(patient, model);

        verify(patientService, times(1)).registerPatient(patient);
        verify(model, times(1)).addAttribute("patients", patients);
        assertEquals("fragments/patient-list :: patientList", viewName);
    }

    @Test
    void testSearchPatients() {
        String name = "John";
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());

        when(patientService.searchPatients(name)).thenReturn(patients);

        String viewName = patientController.searchPatients(name, model);

        verify(patientService, times(1)).searchPatients(name);
        verify(model, times(1)).addAttribute("patients", patients);
        assertEquals("fragments/patient-list :: patientList", viewName);
    }
}
