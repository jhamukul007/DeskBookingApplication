package com.dba.deskbookingapplication.repo;

import com.dba.deskbookingapplication.models.SeatBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatBookingRepo extends JpaRepository<SeatBookingDetails, String> {
}
