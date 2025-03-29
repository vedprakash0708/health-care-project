package com.medicure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {
    @Id
    private String doctorId;
    private String doctorName;
    private String specialization;
    private String contactNumber;
}