package com.dba.deskbookingapplication.models;

import com.dba.deskbookingapplication.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Seat extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
