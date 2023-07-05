package com.dba.deskbookingapplication.jobs;

import com.dba.deskbookingapplication.enums.SeatStatus;
import com.dba.deskbookingapplication.models.Seat;
import com.dba.deskbookingapplication.repo.SeatRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SeatCleanupJob {

    private final SeatRepo seatRepo;

    //Cron job run to clear seat daily at 4 AM
    @Scheduled(cron = "0 0 4 * * ?")
    public void seatCleanup() {
        List<Seat> seats = seatRepo.findAll();
        seats.forEach(seat -> {
            seat.setSeatStatus(SeatStatus.VACANT);
            seatRepo.save(seat);
        });
    }
}
