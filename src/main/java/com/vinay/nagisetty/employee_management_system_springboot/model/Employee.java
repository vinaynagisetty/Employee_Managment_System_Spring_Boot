package com.vinay.nagisetty.employee_management_system_springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name ="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
}
