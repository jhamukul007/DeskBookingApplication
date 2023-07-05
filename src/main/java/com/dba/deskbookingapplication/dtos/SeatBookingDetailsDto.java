package com.dba.deskbookingapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatBookingDetailsDto {
    private String employeeName;
    private Long employeeId;
    private Long seatId;
    private String bookingToken;
}
