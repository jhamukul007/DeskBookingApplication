package com.dba.deskbookingapplication.controllers;

import com.dba.deskbookingapplication.service.seat.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
@AllArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<String> createSeat() {
        seatService.createSeat();
        return ResponseEntity.ok("Seat has been created");
    }

}
