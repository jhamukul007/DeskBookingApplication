package com.dba.deskbookingapplication.service.booking.impl;

import com.dba.deskbookingapplication.dtos.SeatBookingDetailsDto;
import com.dba.deskbookingapplication.enums.SeatStatus;
import com.dba.deskbookingapplication.exception.ResourceNotFoundException;
import com.dba.deskbookingapplication.exception.SlotNotAvailableException;
import com.dba.deskbookingapplication.models.Employee;
import com.dba.deskbookingapplication.models.Seat;
import com.dba.deskbookingapplication.models.SeatBookingDetails;
import com.dba.deskbookingapplication.repo.EmployeeRepo;
import com.dba.deskbookingapplication.repo.SeatBookingRepo;
import com.dba.deskbookingapplication.repo.SeatRepo;
import com.dba.deskbookingapplication.service.booking.SeatBookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Service
@AllArgsConstructor
public class SeatBookingServiceImpl implements SeatBookingService {

    private final EmployeeRepo employeeRepo;
    private final SeatRepo seatRepo;
    private final SeatBookingRepo seatBookingRepo;

    @Override
    @Transactional
    public synchronized SeatBookingDetailsDto bookSeat(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found on id"));
        Seat seat = seatRepo.findFirstBySeatStatusEqualsAndOrderByIdAsc(SeatStatus.VACANT).orElseThrow(() -> new SlotNotAvailableException("Slot not available"));
        SeatBookingDetailsDto bookingDetailsDto = null;
        try {
            SeatBookingDetails seatBookingDetails = SeatBookingDetails.builder()
                    .employee(employee)
                    .seat(seat)
                    .date(new Date())
                    .build();
            seat.setSeatStatus(SeatStatus.RESERVED);
            seatRepo.save(seat);
            seatBookingRepo.save(seatBookingDetails);
            bookingDetailsDto = SeatBookingDetailsDto.builder()
                    .bookingToken(seatBookingDetails.getId())
                    .seatId(seat.getId())
                    .employeeName(employee.getFullName())
                    .employeeId(employeeId)
                    .build();

        } catch (Exception e) {
            log.error("Getting error while booking slot ", e);
            e.printStackTrace();
        }
        return bookingDetailsDto;
    }
}
