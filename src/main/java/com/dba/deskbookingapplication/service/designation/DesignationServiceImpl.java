package com.dba.deskbookingapplication.service.designation;

import com.dba.deskbookingapplication.exception.ResourceAlreadyExist;
import com.dba.deskbookingapplication.exception.ResourceNotFoundException;
import com.dba.deskbookingapplication.models.Designation;
import com.dba.deskbookingapplication.repo.DesignationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DesignationServiceImpl implements DesignationService {
    private final DesignationRepo designationRepo;


    @Override
    public Designation getOrThrowNotFoundById(Long designationId) {
        return designationRepo.findById(designationId).orElseThrow(() -> new ResourceNotFoundException("Designation not found on id "));
    }

    @Override
    public Designation createDesignation(Designation designation) {
        Optional<Designation> existedDesignation = designationRepo.findByTitleEquals(designation.getTitle());
        existedDesignation.ifPresent(des -> new ResourceAlreadyExist("Designation already exist"));
        return designationRepo.save(designation);
    }
}
