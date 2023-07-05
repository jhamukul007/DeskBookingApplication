package com.dba.deskbookingapplication.repo;

import com.dba.deskbookingapplication.enums.SeatStatus;
import com.dba.deskbookingapplication.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepo extends JpaRepository<Seat, Long> {
    Optional<Seat> findFirstBySeatStatusEqualsAndOrderByIdAsc(SeatStatus status);
}
