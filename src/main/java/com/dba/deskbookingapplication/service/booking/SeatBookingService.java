package com.dba.deskbookingapplication.service.booking;

import com.dba.deskbookingapplication.dtos.SeatBookingDetailsDto;

public interface SeatBookingService {
    SeatBookingDetailsDto bookSeat(Long employeeId);
}
