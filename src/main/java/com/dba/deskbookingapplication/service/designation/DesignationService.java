package com.dba.deskbookingapplication.service.designation;

import com.dba.deskbookingapplication.models.Designation;

public interface DesignationService {
    Designation getOrThrowNotFoundById(Long designationId);
    Designation createDesignation(Designation designation);
}
