package com.dba.deskbookingapplication.service.seat.impl;

import com.dba.deskbookingapplication.enums.SeatStatus;
import com.dba.deskbookingapplication.models.Seat;
import com.dba.deskbookingapplication.repo.SeatRepo;
import com.dba.deskbookingapplication.service.seat.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepo seatRepo;

    @Override
    public void createSeat() {
        for (int i = 1; i < 400; i++) {
            seatRepo.save(Seat.builder()
                    .seatStatus(SeatStatus.VACANT)
                    .build());
        }
    }
}
