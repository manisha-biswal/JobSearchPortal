package com.weeklyTest.JobSearchPortal.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Jobs")
public class Job {


    @Id
    private Long id;
    private String title;
    private String description;
    private String location;
    @Min(value = 20000)
    private Double salary;
    @Email
    private String companyEmail;

    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    private Type jobType;

    @NotNull(message = "Date cannot be null")
    @Past(message = "Date must be in the past")
    private LocalDate appliedDate = LocalDate.now();

}