package com.dba.deskbookingapplication.controllers;

import com.dba.deskbookingapplication.models.Designation;
import com.dba.deskbookingapplication.service.designation.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class DesignationController {
    private final DesignationService designationService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Designation createDesignation(@RequestBody Designation designation) {
        return designationService.createDesignation(designation);
    }
}
