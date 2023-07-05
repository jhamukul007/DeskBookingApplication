package com.dba.deskbookingapplication.service.employee.impl;

import com.dba.deskbookingapplication.dtos.EmployeeDto;
import com.dba.deskbookingapplication.models.Designation;
import com.dba.deskbookingapplication.models.Employee;
import com.dba.deskbookingapplication.repo.EmployeeRepo;
import com.dba.deskbookingapplication.service.designation.DesignationService;
import com.dba.deskbookingapplication.service.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DesignationService designationService;

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Designation designation = designationService.getOrThrowNotFoundById(employeeDto.getDesignationId());
        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .designation(designation)
                .build();
        return employeeRepo.save(employee);
    }


}
