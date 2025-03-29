package com.medicure.service;

import com.medicure.model.Doctor;
import com.medicure.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void testRegisterDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorId("D001");
        
        when(doctorRepository.save(any(Doctor.class))).thenReturn(doctor);
        
        Doctor savedDoctor = doctorService.registerDoctor(doctor);
        assertEquals("D001", savedDoctor.getDoctorId());
    }
}