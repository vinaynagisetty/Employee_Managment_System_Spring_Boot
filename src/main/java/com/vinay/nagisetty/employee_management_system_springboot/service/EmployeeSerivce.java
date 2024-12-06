package com.vinay.nagisetty.employee_management_system_springboot.service;

import com.vinay.nagisetty.employee_management_system_springboot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeSerivce {
        Employee saveEmployee(Employee employee);
        List getAllEmployee();
        Employee getEmployeeById(long id);
        Employee updateEmployee(Employee employee,long id);
}
