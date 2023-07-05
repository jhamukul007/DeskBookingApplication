package com.dba.deskbookingapplication.repo;

import com.dba.deskbookingapplication.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
