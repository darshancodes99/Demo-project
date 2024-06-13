package com.codes.darshan.demoProject.services;

import com.codes.darshan.demoProject.dto.EmployeeDTO;
import com.codes.darshan.demoProject.entities.EmployeeEntity;
import com.codes.darshan.demoProject.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {

    final EmployeeRepository  employeeRepository;
    final ModelMapper modelMapper;


    public EmployeeServices(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
      EmployeeEntity employeeEntity = employeeRepository.getById(id);
      return modelMapper.map(employeeEntity , EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity)  , EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployeeById(){
       return employeeRepository.findAll().stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());
    }
}


