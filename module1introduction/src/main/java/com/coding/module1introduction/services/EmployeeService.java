package com.coding.module1introduction.services;

import com.coding.module1introduction.dto.EmployeeDTO;
import com.coding.module1introduction.entities.EmployeeEntity;
import com.coding.module1introduction.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    ModelMapper modelMapper ;

    public EmployeeService(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    public EmployeeDTO employeeById(Long empId) {
        EmployeeEntity empEntity = employeeRepository.findById(empId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id " + empId));
        EmployeeDTO update=modelMapper.map(empEntity, EmployeeDTO.class);
        return update;
    }
    public EmployeeDTO AddEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity empEntity = employeeRepository.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
        return modelMapper.map(empEntity,EmployeeDTO.class);

    }
    public List<EmployeeDTO> getAllEmp(){
        List<EmployeeEntity> empEntity = employeeRepository.findAll();
        List<EmployeeDTO> empDTO = modelMapper.map(empEntity,List.class);
        return empDTO;
    }


    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        EmployeeEntity empEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        empEntity.setId(employeeId);
        EmployeeEntity employeeEntity01 = employeeRepository.save(empEntity);

            return modelMapper.map(employeeEntity01,EmployeeDTO.class);
    }
}
