package com.dba.deskbookingapplication.repo;

import com.dba.deskbookingapplication.enums.DesignationTitle;
import com.dba.deskbookingapplication.models.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DesignationRepo extends JpaRepository<Designation, Long> {
    Optional<Designation> findByTitleEquals(DesignationTitle title);
}
