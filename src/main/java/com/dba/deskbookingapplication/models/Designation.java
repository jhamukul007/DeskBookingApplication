package com.dba.deskbookingapplication.models;

import com.dba.deskbookingapplication.enums.DesignationTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Designation extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private DesignationTitle type;
}
