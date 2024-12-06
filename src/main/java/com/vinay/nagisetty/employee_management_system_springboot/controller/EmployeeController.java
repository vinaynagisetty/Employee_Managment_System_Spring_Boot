package com.vinay.nagisetty.employee_management_system_springboot.controller;

import com.vinay.nagisetty.employee_management_system_springboot.model.Employee;
import com.vinay.nagisetty.employee_management_system_springboot.service.EmployeeSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getallemployee")
    public List<Employee> getallemployee(){
        return employeeSerivce.getAllEmployee() ;


    }
    @GetMapping("/getallemployee/{id}")
    public  ResponseEntity<Employee>  getallemployeeByID(@PathVariable("id")  long employeeID){
        return  new ResponseEntity<>(employeeSerivce.getEmployeeById(employeeID), HttpStatus.OK);
     }

     @PutMapping("/update/{id}")
     public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId ,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeSerivce.updateEmployee(employee,employeeId),HttpStatus.OK);

     }



}
