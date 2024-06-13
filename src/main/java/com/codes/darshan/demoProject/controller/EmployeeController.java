package com.codes.darshan.demoProject.controller;

//Operations
//Get employee
// create employee
// delete employee {id}

import com.codes.darshan.demoProject.dto.EmployeeDTO;
import com.codes.darshan.demoProject.services.EmployeeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private  final EmployeeServices employeeServices;
    public  EmployeeController (EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeServices.getEmployeeById();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeesById(@PathVariable("id") Long id) {
        return employeeServices.getEmployeeById(id);
    }

    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeServices.createNewEmployee(employeeDTO);
    }
}
