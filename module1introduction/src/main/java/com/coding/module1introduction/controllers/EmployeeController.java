package com.coding.module1introduction.controllers;

import com.coding.module1introduction.dto.EmployeeDTO;
import com.coding.module1introduction.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{empId}")
    public EmployeeDTO getemployeeById(@PathVariable Long empId) {

        return employeeService.employeeById(empId);
    }

    @PostMapping("/employee/addEmployee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.AddEmployee(employeeDTO);
    }

    @GetMapping("/employee/getAllEmployee")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmp();
    }
    @PutMapping("/employee/{employeeId}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.updateEmployee(employeeDTO,employeeId);
    }

}

