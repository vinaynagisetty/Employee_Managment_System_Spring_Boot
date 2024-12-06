package com.vinay.nagisetty.employee_management_system_springboot.repository;

import com.vinay.nagisetty.employee_management_system_springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpolyeeRepository extends JpaRepository<Employee,Long> {

}
