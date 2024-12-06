package com.vinay.nagisetty.employee_management_system_springboot.service.imp;

import com.vinay.nagisetty.employee_management_system_springboot.exception.ResourceNotFoundException;
import com.vinay.nagisetty.employee_management_system_springboot.model.Employee;
import com.vinay.nagisetty.employee_management_system_springboot.repository.EmpolyeeRepository;
import com.vinay.nagisetty.employee_management_system_springboot.service.EmployeeSerivce;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeSerivce {

    private EmpolyeeRepository employrepository;

    public EmployeeServiceImpl(EmpolyeeRepository employrepository) {
        this.employrepository = employrepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employrepository.save(employee);
    }

    @Override
    public List getAllEmployee() {
        return employrepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee= employrepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
       else{
           throw  new ResourceNotFoundException("Employee","Id",id);
        }

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee= employrepository.findById(id).orElseThrow(
       ()->   new ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setEmail(employee.getEmail());
        // Update the first name


        // You can add more setters to update other fields
        existingEmployee.setLastName(employee.getLastName());

        employrepository.save(existingEmployee);

        // Save and return the updated employee
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employrepository.findById(id).orElseThrow(
                ()->   new ResourceNotFoundException("Employee","Id",id));
       employrepository.deleteById(id);
    }

//    @Override
//    public Employee updateEmployee(Employee employee, long id) {
//        Employee existingEmployee= employrepository.findById(id).orElseThrow(
//                ()->   new ResourceNotFoundException("Employee","Id",id));
//
////        existingEmployee.setFirstName(employee.getFirstName());
////        existingEmployee.setEmail(employee.getEmail());
////        // Update the first name
////        return employeeRepository.save(existingEmployee);
////
////        // You can add more setters to update other fields
////        existingEmployee.setLastName(employee.getLastName());
////
////        // Save and return the updated employee
//        return  existingEmployee;
//
//    }


}
