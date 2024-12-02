package com.vinay.nagisetty.employee_management_system_springboot.controller;

import com.vinay.nagisetty.employee_management_system_springboot.model.Employee;
import com.vinay.nagisetty.employee_management_system_springboot.service.EmployeeSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employess")
public class EmployeeController {
    private EmployeeSerivce employeeSerivce;
    public EmployeeController(EmployeeSerivce employeeSerivce) {
        this.employeeSerivce = employeeSerivce;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeSerivce.saveEmployee(employee), HttpStatus.CREATED);
    }



}
