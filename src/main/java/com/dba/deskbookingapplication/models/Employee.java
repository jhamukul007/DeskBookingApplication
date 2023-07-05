package com.dba.deskbookingapplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;

    @OneToOne
    private Designation designation;

    public String getFullName() {
        String fullName = "";
        if (StringUtils.hasText(this.firstName))
            fullName += firstName.trim();
        if (StringUtils.hasText(this.lastName))
            fullName += " " + lastName.trim();
        return fullName;
    }
}
