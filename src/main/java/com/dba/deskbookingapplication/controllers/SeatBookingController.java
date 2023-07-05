package com.dba.deskbookingapplication.controllers;

import com.dba.deskbookingapplication.dtos.SeatBookingDetailsDto;
import com.dba.deskbookingapplication.service.booking.SeatBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slot")
@AllArgsConstructor
public class SeatBookingController {

    private final SeatBookingService seatBookingService;

    @PostMapping("/book/{employeeId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public SeatBookingDetailsDto bookSeat(@PathVariable Long employeeId) {
        return seatBookingService.bookSeat(employeeId);
    }

}
