package com.dba.deskbookingapplication.service.employee;

import com.dba.deskbookingapplication.dtos.EmployeeDto;
import com.dba.deskbookingapplication.models.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employee);
}
